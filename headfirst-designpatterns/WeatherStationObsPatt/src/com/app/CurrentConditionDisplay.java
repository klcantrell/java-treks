package com.app;

public class CurrentConditionDisplay implements CustomObserver, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private CustomSubject weatherData;

    public CurrentConditionDisplay(CustomSubject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
