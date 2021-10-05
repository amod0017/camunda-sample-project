package com.github.weather.reporter.kafka.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.weather.reporter.model.WeatherTelemetry;
import com.github.weather.reporter.model.WeatherWarnings;
import com.github.weather.reporter.workflow.corelator.WeatherWarningsCorelator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherWarningListener {
    @Autowired
    WeatherWarningsCorelator weatherWarningsCorelator;
    @KafkaListener(topics = "weatherWarnings")
    public void consume(String message) {
        System.out.println("weatherWarnings received: " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WeatherWarnings weatherWarnings = objectMapper.readValue(message, WeatherWarnings.class);
            System.out.println("weatherWarning object received: " + weatherWarnings);
            weatherWarningsCorelator.correlate(weatherWarnings);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
