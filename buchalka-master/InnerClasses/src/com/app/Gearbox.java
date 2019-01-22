package com.app;

import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private List<Gear> gears;
    private int maxGears;
    private int currentGear;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();

        for (int i = 0; i < maxGears; i++) {
            this.gears.add(new Gear(i , i * 5.3));
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }


    public void changeGear(int newGear) {
        if (newGear >= 0 && newGear < gears.size() && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Scream!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    // inner class
    public class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
            System.out.println("called from inside inner class - max gears: " + Gearbox.this.maxGears);
        }

        public double getRatio() {
            return ratio;
        }
    }
}
