package com.multithreading;

/*
We need a Voting thread to determine finalists then a Counting thread to tally the votes */

public class App {
    public static void main(String[] args) throws InterruptedException {
        Design d1 = new Design(1, "Design1");
        VotingRunnable votingRunnableD1 = new VotingRunnable(d1);
        CountingRunnable countingRunnableD1 = new CountingRunnable(d1);

        Thread votingThreadD1 = new Thread(votingRunnableD1);
        Thread countingThreadD1 = new Thread(countingRunnableD1);

        votingThreadD1.start();
        votingThreadD1.join();
        countingThreadD1.start();

        Design d2 = new Design(2, "Design2");
        VotingRunnable votingRunnableD2 = new VotingRunnable(d2);
        CountingRunnable countingRunnableD2 = new CountingRunnable(d2);

        Thread votingThreadD2 = new Thread(votingRunnableD2);
        Thread countingThreadD2 = new Thread(countingRunnableD2);

        votingThreadD2.start();
        votingThreadD2.join();
        countingThreadD2.start();

        Design d3 = new Design(3, "Design3");
        VotingRunnable votingRunnableD3 = new VotingRunnable(d3);
        CountingRunnable countingRunnableD3 = new CountingRunnable(d3);

        Thread votingThreadD3 = new Thread(votingRunnableD3);
        Thread countingThreadD3 = new Thread(countingRunnableD3);

        votingThreadD3.start();
        votingThreadD3.join();
        countingThreadD3.start();
    }
}

/* Output:
Voting going on for design: Design1
Voting going on for design: Design2
Voting going on for design: Design3
Counting votes for design: Design1 has 1 votes.
Counting votes for design: Design2 has 1 votes.
Counting votes for design: Design3 has 1 votes.
Total votes for design Design2: 1
Total votes for design Design1: 1
Total votes for design Design3: 1
*/
