package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(30, true);
        printer.print(1);
        printer.print(10);
        printer.toggleDuplexMode();
        printer.print(50);
        printer.fillToner(180);
    }
}
