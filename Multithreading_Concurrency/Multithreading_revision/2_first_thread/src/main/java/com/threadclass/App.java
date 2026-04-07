// demonstration of Thread clas that implements Runnable interface
// Thread class implments Runnable interface for the run() method, so we can create a thread by extending the Thread class and overriding the run() method

package com.threadclass;

public class App {
    public static void main(String[] args) {
        // Multithreading
        for (int count = 1; count <= 3; count++) {
            FirstThread thread = new FirstThread(count); // create an instance of the FirstThread class
            thread.start(); // start the thread, which will call the run() method of the FirstThread class
        }
        // there is no order of execution of the threads, it depends on the thread
        // scheduler of the JVM, so the output may vary each time we run the program
        // each thread gets its own priority value at the time of creation
        // when we re-run the same program, the thread priorities get re-created and the
        // thread scheduler may choose to run the threads in a different order, which
        // is why we see different outputs each time we run the program.

        /*
         * MyRunnable myRunnable = new MyRunnable(); // create an instance of the
         * MyRunnable class
         * Thread thread2 = new Thread(myRunnable); // create a new thread and pass the
         * MyRunnable instance to the Thread
         */
    }
}

/*
 * Output
 * Iteration: 2 from thread number: 1
 * Iteration: 3 from thread number: 2
 * Iteration: 4 from thread number: 2
 * Iteration: 4 from thread number: 3
 * Iteration: 3 from thread number: 1
 * Iteration: 5 from thread number: 2
 * Iteration: 5 from thread number: 3
 * Iteration: 4 from thread number: 1
 * Iteration: 5 from thread number: 1
 */