package com.threadclass;
// Second method to implement a thread from Runnable interface, we can create a class that implements the Runnable interface and override the run() method to define the code that will be executed when the thread is started. In this case, it simply prints a message to the console.

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is a thread implemented using Runnable interface.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}
