package com.weatherapp.weatherClient.weather;

import com.weatherapp.dto.OpenWeatherDto;
import com.weatherapp.dto.WeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Component
public class WeatherClient {

    public static final String SAMPLE = "Przykladowy tekst";
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "d60b60482c51ee9e765c6d8bfaecf6d6";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherDto openWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&lang=pl&units=metric",
                OpenWeatherDto.class,
                city, API_KEY);
        return WeatherDto.builder()
                .humidity(openWeatherDto.getMain().getHumidity())
                .pressure(openWeatherDto.getMain().getPressure())
                .temperature(openWeatherDto.getMain().getTemp())
                .sunRises(openWeatherDto.getSys().getSunrise())
                .sunGoesDown(openWeatherDto.getSys().getSunset())
                .windSpeed(openWeatherDto.getWind().getSpeed())
//                .description(openWeatherDto.getWeather().getDescription())
                .description(SAMPLE)
                .build();
    }

    public OpenWeatherDto getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}98&lon={lon}8&&lang=plunits=metric&appid={apiKey}&exclude=minutely,hourly",
                OpenWeatherDto.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
