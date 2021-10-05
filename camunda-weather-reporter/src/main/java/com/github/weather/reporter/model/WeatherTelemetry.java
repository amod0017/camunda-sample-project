package com.github.weather.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherTelemetry implements Serializable {
    private String time;
    private String weatherStatus;
    private String temp;
    private String windStatus;
    private String humidityValue;
    private String feelsLikeTemp;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"time\" :");
        builder.append(time);
        builder.append(", \"weatherStatus\" :");
        builder.append(weatherStatus);
        builder.append(", \"temp\" :");
        builder.append(temp);
        builder.append(", \"windStatus\" :");
        builder.append(windStatus);
        builder.append(", \"humidityValue\" :");
        builder.append(humidityValue);
        builder.append(", \"feelsLikeTemp\" :");
        builder.append(feelsLikeTemp);
        builder.append("}");
        return builder.toString();
    }
}
