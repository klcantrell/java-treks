package com.app;

import java.util.Arrays;

public class MyMath {
    public int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
