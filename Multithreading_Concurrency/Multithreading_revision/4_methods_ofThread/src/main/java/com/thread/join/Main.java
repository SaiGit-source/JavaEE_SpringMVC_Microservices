package com.thread.join;

// join() method makes the current thread or main thread wait until the specified join() method thread is finished

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] marks = { 90, 80, 70, 60, 50, 40, 30, 20, 10, 0 };
        Thread marksThread = new Thread(new Marks(marks));
        Thread avgThread = new Thread(new Average(marks));
        marksThread.start();
        try {
            marksThread.join(); // make main thread or current thread to wait until marksThread is finished
            // this guarantees marksThread and avgThread are executed in the order we want
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        avgThread.start();
        System.out.println("Main thread is finished");
    }

}

/* Output
Marks of student 4 is: 58
Marks of student 5 is: 49
Marks of student 6 is: 26
Marks of student 7 is: 91
Marks of student 8 is: 34
Marks of student 9 is: 23
Marks of student 10 is: 26
Main thread is finished
Average marks of students is: 48
*/