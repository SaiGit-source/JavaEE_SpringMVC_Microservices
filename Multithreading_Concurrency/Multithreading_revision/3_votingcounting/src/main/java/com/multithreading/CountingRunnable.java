package com.multithreading;

public class CountingRunnable implements Runnable {
    private Design d;
    protected boolean doStop = false;

    public CountingRunnable(Design d) {
        this.d = d;
    }

    @Override
    public void run() { 
        // System.out.println("Counting thread is running...");
        // Simulate counting process
        System.out.println("Counting votes for design: " + d.getName() + " has " + d.getVotes().size() + " votes.");
        long totalVotes = d.getVotes().stream().mapToLong(Long::longValue).sum();
        System.out.println("Total votes for design " + d.getName() + ": " + totalVotes);
    }

}
