package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import static com.app.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        //allows jvm to optimize thread management especially for large number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

	    MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_RED, bufferLock);
	    MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
	    MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);

	    executorService.execute(myProducer);
	    executorService.execute(myConsumer1);
	    executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed from the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(ThreadColor.ANSI_GREEN + future.get());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(ThreadColor.ANSI_GREEN + "Something went wrong");
        }

	    executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding... " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (bufferLock.tryLock()) {
                //bufferLock.lock(); don't need this with the tryLock
                try {
                    if (buffer.isEmpty()) {
                        // bufferLock.unlock(); // don't need this with try/finally (would throw error)
                        continue;
                    }
                    System.out.println(color + "Count of tryLock unsuccessful: " + count);
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        // bufferLock.unlock(); // don't need this with try/finally (would throw error)
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                count++;
            }
        }
    }
}