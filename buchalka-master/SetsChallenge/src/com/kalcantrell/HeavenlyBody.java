package com.kalcantrell;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final String bodyType;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Map<String, String> getUniqueKey() {
        HashMap<String, String> uniqueKey = new HashMap<>();
        uniqueKey.put("name", this.name);
        uniqueKey.put("bodyType", this.bodyType);
        return uniqueKey;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass() " + obj.getClass());
        System.out.println("this.getClass() " + this.getClass());

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Map<String, String> objKey = ((HeavenlyBody) obj).getUniqueKey();
        return this.getUniqueKey().equals(objKey);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode called");
        return this.name.hashCode() + this.bodyType.hashCode() + 57;
    }
}
