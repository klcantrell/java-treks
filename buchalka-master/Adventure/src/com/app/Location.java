package com.app;

import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if (exits != null) {
            this.exits = new HashMap<>(exits); // to make it immutable and prevent the temp reference from being able to change this list
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
