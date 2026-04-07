package com.thread.interrupt2;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Thread is printing " + i);
            /*
             * try {
             * Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
             * } catch (InterruptedException e) {
             * System.out.println("TaskThread was interrupted!");
             * // e.printStackTrace();
             * break; // Exit the loop if interrupted or terminate the thread
             * // it will terminate the for loop and the thread will end. If we don't break
             * the
             * // loop, the thread will continue to run and print numbers even after being
             * // interrupted, which is not the desired behavior in this case.
             */
            if (Thread.interrupted()) { // if true, thread has received an interrupt signal so we should breakout of the
                                        // loop. It also clears the
                                        // interrupted status of the thread.
                System.out.println("TaskThread was interrupted!"); // it terminates itself
                break; // Exit the loop if interrupted or terminate the thread
            } // Clear the interrupted status of the thread

        }
    }

}

/* It's possible to respond to an interruption request when no InterruptedException is thrown with the help of the static interrupted() method. Call Thread.interrupted() to check if the interrupted status flag is true. If it’s true, it means that the thread has received a request to interrupt its task. Then you can terminate the long running task. */