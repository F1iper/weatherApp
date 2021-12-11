package com.weatherapp.service;

import com.weatherapp.model.WeatherDto;
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
        String response = weatherClient.getWeatherForCity("warszawa");
        log.info(response);
        String forecast = weatherClient.getForecast(52.2298, 21.0118);
        log.info(forecast);

        return null;
    }
}
