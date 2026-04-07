package com.thread.interrupt;

// we have two threads, main thread and worker thread. The main thread will sleep for 3 seconds and then interrupt the worker thread. The worker thread will print numbers from 1 to 100, sleeping for 1 second between prints. When the worker thread is interrupted, it will catch the InterruptedException and print a message before exiting the loop.
// in MyRunnable class, we are invoking the sleep() method inside the run() method, every 1 second. 
// sleep() method is a blocking method that responds to an interruption by throwing an InterruptedException. 
public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread taskThread = new Thread(myRunnable);
        taskThread.start();

        try {
            Thread.sleep(3000); // Main thread sleeps for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is interrupting the worker thread...");
        taskThread.interrupt(); // Interrupt the worker thread
        System.out.println("Is the worker thread interrupted? " + taskThread.isInterrupted());

    }

}

/*
 * Output
 * Thread is printing 2
 * Thread is printing 3
 * Main thread is interrupting the worker thread...
 * Is the worker thread interrupted? true
 * TaskThread was interrupted!
 * java.lang.InterruptedException: sleep interrupted
 * at java.base/java.lang.Thread.sleepNanos0(Native Method)
 * at java.base/java.lang.Thread.sleepNanos(Thread.java:509)
 * at java.base/java.lang.Thread.sleep(Thread.java:540)
 * at com.thread.interrupt.MyRunnable.run(MyRunnable.java:9)
 * at java.base/java.lang.Thread.run(Thread.java:1474)
 * 
 */

/*
 * Output
 * Thread is printing 1
 * Thread is printing 2
 * Thread is printing 3
 * Main thread is interrupting the worker thread...
 * TaskThread was interrupted!
 * Is the worker thread interrupted? true
 */