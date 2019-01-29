package com.kalcantrell;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "planet");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        return super.addSatellite(satellite);
    }
}
