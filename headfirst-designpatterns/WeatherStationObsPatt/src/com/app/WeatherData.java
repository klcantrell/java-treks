package com.app;

import java.util.ArrayList;

public class WeatherData implements CustomSubject {
    private ArrayList<CustomObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<CustomObserver>();
    }

    public void registerObserver(CustomObserver o) {
        observers.add(o);
    }

    public void removeObserver(CustomObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    public void notifyObservers() {
        for (CustomObserver observer: observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
