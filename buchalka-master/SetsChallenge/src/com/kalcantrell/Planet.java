package com.kalcantrell;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        HeavenlyBody.Key satelliteKey = satellite.getKey();
        BodyType satelliteType = satelliteKey.getBodyType();
        if (satelliteType == BodyType.MOON) {
            return super.addSatellite(satellite);
        }
        return false;
    }
}
