package com.app;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread");
        //anotherThread.run(); // don't do this...will actually run this on the main thread
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread myAnonymousRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_CYAN + "Hello from the anonymous runnable");
                try {
                    //anotherThread.join(2000); // adding a timeout
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all.  I was interrupted");
                }
            }
        });
        myAnonymousRunnableThread.start();
        //anotherThread.interrupt(); // this is how you interrupt a thread

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
    }
}
