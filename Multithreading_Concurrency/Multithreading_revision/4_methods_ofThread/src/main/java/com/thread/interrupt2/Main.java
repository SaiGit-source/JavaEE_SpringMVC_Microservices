package com.thread.interrupt2;

// we have two threads, main thread and worker thread. The main thread will sleep for 3 seconds and then interrupt the worker thread. The worker thread will print numbers from 1 to 100, sleeping for 1 second between prints. When the worker thread is interrupted, it will catch the InterruptedException and print a message before exiting the loop.
// in MyRunnable class, we are invoking the sleep() method inside the run() method, every 1 second. 
// sleep() method is a blocking method that responds to an interruption by throwing an InterruptedException. 
public class Main {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread taskThread = new Thread(myRunnable);
        taskThread.start();
        System.out.println("Main thread is interrupting the worker thread...");
        taskThread.interrupt(); // Interrupt the worker thread

        try {
            Thread.sleep(3000); // Main thread sleeps for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Is the worker thread interrupted? " + taskThread.isInterrupted()); // Thread.interrupted() method clears this isInterrupted flag thats why false is printed

    }

}



/* Output

Main thread is interrupting the worker thread...
Thread is printing 1
TaskThread was interrupted!
Is the worker thread interrupted? false

*/