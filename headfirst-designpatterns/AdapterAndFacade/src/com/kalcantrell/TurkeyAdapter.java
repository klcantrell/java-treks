package com.kalcantrell;

import java.util.stream.IntStream;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        IntStream.range(0, 5).forEach(n -> turkey.fly());
    }
}
