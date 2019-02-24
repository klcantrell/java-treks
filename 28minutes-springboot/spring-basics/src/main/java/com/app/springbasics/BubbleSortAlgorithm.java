package com.app.springbasics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubbleSort")
public class BubbleSortAlgorithm implements SortAlgorithm {
    public int[] sort (int[] numbers) {
        // logic for bubble sort
        return numbers;
    }
}
