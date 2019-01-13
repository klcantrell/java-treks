package com.app;

public class Main {

    public static void main(String[] args) {
	    WeatherData weatherData = new WeatherData();
	    CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
	    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

	    weatherData.setMeasurements(80f, 65f, 30.4f);
	    weatherData.setMeasurements(82f, 70f, 29.2f);
	    weatherData.setMeasurements(78f, 90f, 29.2f);
    }
}
