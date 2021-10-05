package com.github.weather.reporter.kafka.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.weather.reporter.model.WeatherTelemetry;
import com.github.weather.reporter.workflow.process.ReportGeneratorProcessInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherTelemetryListener {
    @Autowired
    ReportGeneratorProcessInitializer reportGeneratorProcessInitializer;

    @KafkaListener(topics = "weatherTelemetry")
    public void consume(String message) {
        System.out.println("weatherWarning received: " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WeatherTelemetry weatherTelemetry = objectMapper.readValue(message, WeatherTelemetry.class);
            System.out.println("weatherWarning object received: " + weatherTelemetry);
            reportGeneratorProcessInitializer.startReportGeneratorProcess(weatherTelemetry);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @KafkaListener(topics = "weatherTelemetry",
//            containerFactory = "weatherTelemetryKafkaListenerFactory")
//    public void consumeJson(WeatherTelemetry weatherTelemetry) {
//        System.out.println("Consumed JSON Message: " + weatherTelemetry);
//    }
}
