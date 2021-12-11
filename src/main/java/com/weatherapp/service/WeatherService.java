package com.weatherapp.service;

import com.weatherapp.dto.WeatherDto;
import com.weatherapp.weatherClient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather() {
        log.info(String.valueOf(System.nanoTime()));
        return weatherClient.getWeatherForCity("warszawa");
    }
}
