package com.kalcantrell;

public class Printer {
    private static int maxTonerLevel = 200;
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplexOn;

    public Printer(int tonerLevel, boolean duplexOn) {
        if (tonerLevel > -1 && tonerLevel <= maxTonerLevel) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = 0;
        }
        this.duplexOn = duplexOn;
        this.pagesPrinted = 0;
    }

    public void fillToner(int amount) {
        if (amount <= 0) {
            System.out.println("Can't add negative or zero toner");
            return;
        }
        if (tonerLevel + amount > maxTonerLevel) {
            tonerLevel = maxTonerLevel;
        } else {
            this.tonerLevel += amount;
        }
        System.out.println("Toner level now at " + tonerLevel);
    }

    public void print(int pages) {
        if (pages > tonerLevel) {
            System.out.println("Can't print all pages");
            return;
        }
        int pagesUsed;
        if (duplexOn) {
            pagesUsed = pages / 2 + pages % 2;
        } else {
            pagesUsed = pages;
        }
        pagesPrinted += pagesUsed;
        tonerLevel -= pages;
        System.out.println("Total pages printed " + pagesPrinted);
        System.out.println("Toner level " + tonerLevel);
    }

    public void toggleDuplexMode() {
        this.duplexOn = !duplexOn;
        String modeMessage = duplexOn ? "on" : "off";
        System.out.println("Duplex is " + modeMessage + "!");
    }
}
