package com.github.weather.reporter.workflow.process;

import com.github.weather.reporter.model.WeatherTelemetry;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ReportGeneratorProcessInitializer {
    @Autowired
    private RuntimeService runtimeService;

    public ProcessInstance startReportGeneratorProcess(WeatherTelemetry weatherTelemetry) {
        return runtimeService
                .startProcessInstanceByKey("weatherReportOrchestrator",
                        weatherTelemetry.getTime(), Variables.putValue("weatherTelemetry", weatherTelemetry)
                                .putValue("weatherStatus", weatherTelemetry.getWeatherStatus())
                                .putValue("temp", weatherTelemetry.getTemp())
                );
    }
}
