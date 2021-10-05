package com.github.weather.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * FIXME
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherWarnings implements Serializable {
    List<String> weatherWarnings = new ArrayList<>();
}
