package com.app.springbasics;

public class BinarySearchImpl {
    public int binarySearch(int[] numbers, int numberToSearchFor) {
        // implement sort logic using bubble sort
        // tightly coupled...how to switch out algorithm to say quick sort?
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        bubbleSortAlgorithm.sort(numbers);
        // search the array
        return 3;
    }
}
