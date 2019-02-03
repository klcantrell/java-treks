package com.app;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.app.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        //allows jvm to optimize thread management especially for large number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

	    MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_RED);
	    MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);
	    MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

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
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(color + "Adding... " + num);
            try {
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted");
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "Count of tryLock unsuccessful: " + count);
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println("Consumer was interrupted");
                }
            }
        }
    }
}