package com.app;

import java.util.function.Supplier;

public class Challenge6 {
    public static void main(String[] args) {
        Supplier<String> javaIsOk = () -> "Java is ok";
        String mySuppliedValue = javaIsOk.get();
        System.out.println(mySuppliedValue);
    }
}
