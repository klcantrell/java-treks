package com.kalcantrell;

public class Printer {
    private static int maxTonerLevel = 200;
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplexOn;

    public Printer(int tonerLevel, boolean duplexOn) {
        this.tonerLevel = tonerLevel;
        this.duplexOn = duplexOn;
        this.pagesPrinted = 0;
    }

    public void fillToner(int amount) {
        if (tonerLevel + amount > maxTonerLevel) {
            tonerLevel = maxTonerLevel;
        } else {
            this.tonerLevel += amount;
        }
    }

    public void print() {
        if (duplexOn) {
            pagesPrinted += 2;
        } else {
            pagesPrinted += 1;
        }
        System.out.println("Total pages printed " + pagesPrinted);
    }

    public void toggleDuplexMode() {
        this.duplexOn = !duplexOn;
        String modeMessage = duplexOn ? "on" : "off";
        System.out.println("Duplex is " + modeMessage + "!");
    }
}
