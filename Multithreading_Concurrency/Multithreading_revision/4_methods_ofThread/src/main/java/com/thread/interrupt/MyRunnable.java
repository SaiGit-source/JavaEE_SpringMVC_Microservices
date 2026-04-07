package com.thread.interrupt;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Thread is printing " + i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                System.out.println("TaskThread was interrupted!");
                // e.printStackTrace();
                break; // Exit the loop if interrupted or terminate the thread
                // it will terminate the for loop and the thread will end. If we don't break the
                // loop, the thread will continue to run and print numbers even after being
                // interrupted, which is not the desired behavior in this case.

            }
        }
    }

}
