package com.multithreading;

public class VotingRunnable implements Runnable {
    private Design d;

    public VotingRunnable(Design d) {
        this.d = d;
    }

    @Override
    public void run() {
        // System.out.println("Voting thread is running...");
        // Simulate voting process
        System.out.println("Voting going on for design: " + d.getName());
        d.getVotes().add(1L); // 1 vote for a design per thread
}
}
