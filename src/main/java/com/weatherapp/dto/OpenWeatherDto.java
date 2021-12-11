package com.weatherapp.dto;

import lombok.Getter;

@Getter
public class OpenWeatherDto {
     private OpenWeatherMainDto main;
     private OpenWeatherWindDto wind;
     private OpenWeatherSysDto sys;
}
