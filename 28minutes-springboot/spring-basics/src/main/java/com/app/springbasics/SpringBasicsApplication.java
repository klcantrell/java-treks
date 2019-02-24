package com.app.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsApplication {

    public static void main(String[] args) {
        BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
        int result = binarySearch.binarySearch(new int[] {12, 3, 4}, 3);

        System.out.println(result);

        SpringApplication.run(SpringBasicsApplication.class, args);
    }

}
