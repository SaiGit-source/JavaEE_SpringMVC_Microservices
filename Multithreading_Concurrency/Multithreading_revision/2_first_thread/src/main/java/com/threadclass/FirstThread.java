package com.threadclass;

// FirstThread is a subclass of the Thread class, which means it inherits the properties and methods of the Thread class. By overriding the run() method, we can define the code that will be executed when the thread is started. In this case, it simply prints a message to the console.

public class FirstThread extends Thread {
    private int number;

    public FirstThread(int count) {
        this.number = count;
    }

    @Override
    public void run() {
        System.out.println("This thread is from the Thread class.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i + " from thread number: " + number);
        }
    }

}
