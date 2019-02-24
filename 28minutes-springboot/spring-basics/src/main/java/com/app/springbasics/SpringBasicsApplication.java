package com.app.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {

    public static void main(String[] args) {
        // spring will now handle this
        // BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());

        ApplicationContext applicationContext = SpringApplication.run(SpringBasicsApplication.class, args);
        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

        int result = binarySearch.binarySearch(new int[] {12, 3, 4}, 3);
        System.out.println(result);
    }

}
