package com.github.weather.reporter.workflow.corelator;

import com.github.weather.reporter.model.WeatherWarnings;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherWarningsCorelator {
    @Autowired
    RuntimeService runtimeService;

    public void correlate(WeatherWarnings weatherWarnings) {
        runtimeService.createMessageCorrelation("weatherWarnings")
                .processInstanceBusinessKey("2021-10-03T05:30:36Z")
                .setVariable("warnings",weatherWarnings.getWeatherWarnings()).correlate();
    }
}
