package com.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        CompletableFuture<String> whatsMyName = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Kal";
        });

        // just run some code with value returned from completable future
        CompletableFuture<Void> printMyName = whatsMyName.thenAccept(name -> System.out.println(name));
        try {
            printMyName.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // synchronously perform transformations
        CompletableFuture<String> whatsMyFullName = whatsMyName.thenApply(name -> name + " Cantrell");
        try {
            System.out.println(whatsMyFullName.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // compose completable futures
        CompletableFuture<Integer> ageFromName = whatsMyName
                .thenCompose(name -> Main.getAge(name));
        try {
            System.out.println(ageFromName.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> getAge(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Getting age...");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (name.equals("Kal")) {
                return 29;
            } else {
                return 0;
            }
        });
    }
}
