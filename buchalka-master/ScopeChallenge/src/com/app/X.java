package com.app;


import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x) {
        this.x = x.nextInt();
        x.nextLine();
        x.close();
    }

    public void x() {
        for (int x = 0; x <= 12; x++) {
            System.out.println(this.x + " * " + x + " = " + this.x * x);
        }
    }
}
