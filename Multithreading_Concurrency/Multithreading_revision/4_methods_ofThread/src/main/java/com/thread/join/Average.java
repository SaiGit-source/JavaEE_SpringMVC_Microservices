package com.thread.join;

public class Average implements Runnable {
    int[] marks;
    public Average(int[] marks){
        this.marks = marks;
    }

    @Override
    public void run(){
        int sum = 0;
        for (int i=0; i<10; i++){
            sum += marks[i];
        }
        System.out.println("Average marks of students is: " + (sum/10));
    }

}
