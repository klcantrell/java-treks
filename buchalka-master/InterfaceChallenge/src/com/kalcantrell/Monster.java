package com.kalcantrell;

import java.util.ArrayList;
import java.util.List;


public class Monster implements Saveable {
    String name;
    String weapon;
    String area;

    public Monster() {
    }

    public Monster(String name, String weapon, String area) {
        this.name = name;
        this.weapon = weapon;
        this.area = area;
    }

    public List<String> serialize() {
        ArrayList<String> properties = new ArrayList<>();
        properties.add(name);
        properties.add(weapon);
        properties.add(area);
        return properties;
    }

    public void load(List<String> properties) {
        name = properties.get(0);
        weapon = properties.get(1);
        area = properties.get(2);
    }

    public String toString() {
        return name + " wields a " + weapon + " in " + area;
    }
}
