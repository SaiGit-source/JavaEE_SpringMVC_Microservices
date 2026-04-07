package com.thread;

// Java thread allows you to pause for a while using the sleep() method. The sleep() method is a static method of the Thread class that causes the currently executing thread to pause for a specified amount of time. The time is specified in milliseconds.

public class Pause
{
    public static void main( String[] args )
    {
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread is printing " + i);
            if (i==5){
                System.out.println("Main thread is sleeping for 2 seconds...");
                try {
                    Thread.sleep(2000); // Sleep for 2 seconds (2000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/* Output
Main thread is printing 1
Main thread is printing 2
Main thread is printing 3
Main thread is printing 4
Main thread is printing 5
Main thread is sleeping for 2 seconds...
Main thread is printing 6
Main thread is printing 7
Main thread is printing 8
Main thread is printing 9

*/