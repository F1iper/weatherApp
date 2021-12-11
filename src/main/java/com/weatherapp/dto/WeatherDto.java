package com.weatherapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
    private float temperature;
    private int pressure;
    private int humidity;
    private double windSpeed;
    private int sunRises;
    private int sunGoesDown;
}
