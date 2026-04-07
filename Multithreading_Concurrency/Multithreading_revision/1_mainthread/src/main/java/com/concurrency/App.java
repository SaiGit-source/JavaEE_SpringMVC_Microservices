package com.concurrency;

// main() method is run by the main thread and it's a special thread and a non-daemon thread. non-daemon threads are not background threads and they are user threads.
// main thread is the default thread that is created by the JVM when we run a Java program. It is the thread that executes the main() method of our program. We can create additional threads in our program, but the main thread will always be there to execute the main() method. The main thread is responsible for starting and managing other threads in the program. It is also responsible for handling any uncaught exceptions that may occur in the program.

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

// we didnt create any thread explicitly but saw the execution of the default
// thread
// Output: main is running
