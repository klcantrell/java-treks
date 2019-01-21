package com.kalcantrell;

import java.util.ArrayList;
import java.util.List;

public class Character implements Saveable {
    private String name;
    private String weapon;
    private String hometown;
    private int hitPoints;

    public Character() {
    }

    public Character(String name, String weapon, String hometown) {
        this.name = name;
        this.weapon = weapon;
        this.hometown = hometown;
        this.hitPoints = 50;
    }

    public List<String> serialize() {
        List<String> properties = new ArrayList<>();
        properties.add(name);
        properties.add(weapon);
        properties.add(hometown);
        properties.add(Integer.toString(hitPoints));
        return properties;
    }

    public void load(List<String> properties) {
        name = properties.get(0);
        weapon = properties.get(1);
        hometown = properties.get(2);
        if (properties.size() > 3) {
            hitPoints = Integer.parseInt(properties.get(3));
        } else {
            hitPoints = 50;
        }
    }

    public String toString() {
        return name +
                " wields a " + weapon +
                " in " + hometown +
                " and has " + hitPoints + " hitpoints";
    }
}
