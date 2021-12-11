package com.weatherapp.weatherClient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "d60b60482c51ee9e765c6d8bfaecf6d6";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getWeatherForCity(String city) {
        return callGetMethod("weather?q={city}&appid={apiKey}&lang=pl&units=metric",
                city, API_KEY);
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}98&lon={lon}8&&lang=plunits=metric&appid={apiKey}&exclude=minutely,hourly",
                lat, lon, API_KEY);
    }

    private String callGetMethod(String url, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                String.class, objects);
    }
}
