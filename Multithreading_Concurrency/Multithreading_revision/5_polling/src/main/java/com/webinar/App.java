package com.webinar;

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
        //votingThreadD1.join();
        countingThreadD1.start();

        Design d2 = new Design(2, "Design2");
        VotingRunnable votingRunnableD2 = new VotingRunnable(d2);
        CountingRunnable countingRunnableD2 = new CountingRunnable(d2);

        Thread votingThreadD2 = new Thread(votingRunnableD2);
        Thread countingThreadD2 = new Thread(countingRunnableD2);

        votingThreadD2.start();
        //votingThreadD2.join();
        countingThreadD2.start();

        Design d3 = new Design(3, "Design3");
        VotingRunnable votingRunnableD3 = new VotingRunnable(d3);
        CountingRunnable countingRunnableD3 = new CountingRunnable(d3);

        Thread votingThreadD3 = new Thread(votingRunnableD3);
        Thread countingThreadD3 = new Thread(countingRunnableD3);

        votingThreadD3.start();
        //votingThreadD3.join();
        countingThreadD3.start();

        // we stop main thread for 30 sec. it allows voting and counting threads to execute for 30 seconds.
        try {
            Thread.sleep(30000); // Wait for counting threads to finish
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        // we are asking voting and counting to stop
        votingRunnableD1.doStop = true;
        votingRunnableD2.doStop = true;
        votingRunnableD3.doStop = true;
        countingRunnableD1.doStop = true;
        countingRunnableD2.doStop = true;
        countingRunnableD3.doStop = true;

        System.out.println("Voting has stopped for design: " + d1.getName());
        System.out.println("Final vote count for design: " + d1.getName() + " is " + d1.getVotes().size());
        System.out.println("Voting has stopped for design: " + d2.getName());
        System.out.println("Final vote count for design: " + d2.getName() + " is " + d2.getVotes().size());
        System.out.println("Voting has stopped for design: " + d3.getName());
        System.out.println("Final vote count for design: " + d3.getName() + " is " + d3.getVotes().size());

    }
}


/* Output
Voting going on for design: Design3
Counting votes for design: Design2 has 0 votes.
Voting going on for design: Design2
Voting going on for design: Design1
Counting votes for design: Design3 has 0 votes.
Counting votes for design: Design1 has 0 votes.
Total votes for design Design3: 1
Total votes for design Design2: 1
Total votes for design Design1: 1
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Counting votes for design: Design3 has 2 votes.
Total votes for design Design3: 2
Counting votes for design: Design2 has 2 votes.
Total votes for design Design2: 2
Counting votes for design: Design1 has 2 votes.
Total votes for design Design1: 2
Voting going on for design: Design1
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design2
Voting going on for design: Design3
Counting votes for design: Design2 has 5 votes.
Counting votes for design: Design3 has 4 votes.
Total votes for design Design2: 5
Total votes for design Design3: 4
Counting votes for design: Design1 has 4 votes.
Total votes for design Design1: 4
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 7 votes.
Total votes for design Design2: 7
Counting votes for design: Design3 has 5 votes.
Counting votes for design: Design1 has 7 votes.
Total votes for design Design3: 5
Total votes for design Design1: 7
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design3
Voting going on for design: Design2
Counting votes for design: Design2 has 9 votes.
Total votes for design Design2: 9
Counting votes for design: Design3 has 8 votes.
Total votes for design Design3: 8
Counting votes for design: Design1 has 8 votes.
Total votes for design Design1: 8
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design1
Counting votes for design: Design2 has 10 votes.
Total votes for design Design2: 10
Counting votes for design: Design3 has 10 votes.
Total votes for design Design3: 10
Counting votes for design: Design1 has 10 votes.
Total votes for design Design1: 10
Voting going on for design: Design3
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design2
Voting going on for design: Design1
Counting votes for design: Design3 has 12 votes.
Counting votes for design: Design2 has 12 votes.
Total votes for design Design3: 12
Total votes for design Design2: 12
Counting votes for design: Design1 has 11 votes.
Total votes for design Design1: 11
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design3 has 13 votes.
Counting votes for design: Design2 has 13 votes.
Total votes for design Design3: 13
Total votes for design Design2: 13
Counting votes for design: Design1 has 13 votes.
Total votes for design Design1: 13
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design3
Voting going on for design: Design2
Counting votes for design: Design2 has 15 votes.
Counting votes for design: Design3 has 16 votes.
Total votes for design Design2: 15
Total votes for design Design3: 16
Counting votes for design: Design1 has 14 votes.
Total votes for design Design1: 14
Voting going on for design: Design1
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 17 votes.
Total votes for design Design2: 17
Counting votes for design: Design3 has 18 votes.
Total votes for design Design3: 18
Counting votes for design: Design1 has 18 votes.
Total votes for design Design1: 18
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design1
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 20 votes.
Total votes for design Design2: 20
Counting votes for design: Design3 has 19 votes.
Total votes for design Design3: 19
Counting votes for design: Design1 has 21 votes.
Total votes for design Design1: 21
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 22 votes.
Total votes for design Design2: 22
Counting votes for design: Design3 has 20 votes.
Total votes for design Design3: 20
Counting votes for design: Design1 has 23 votes.
Total votes for design Design1: 23
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 23 votes.
Total votes for design Design2: 23
Counting votes for design: Design3 has 21 votes.
Total votes for design Design3: 21
Counting votes for design: Design1 has 24 votes.
Total votes for design Design1: 24
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design1
Counting votes for design: Design2 has 25 votes.
Total votes for design Design2: 25
Counting votes for design: Design3 has 23 votes.
Total votes for design Design3: 23
Counting votes for design: Design1 has 26 votes.
Total votes for design Design1: 26
Voting going on for design: Design3
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design2
Counting votes for design: Design2 has 27 votes.
Total votes for design Design2: 27
Counting votes for design: Design3 has 25 votes.
Total votes for design Design3: 25
Counting votes for design: Design1 has 27 votes.
Total votes for design Design1: 27
Voting going on for design: Design2
Voting going on for design: Design3
Voting going on for design: Design1
Voting going on for design: Design1
Voting has stopped for design: Design1
Final vote count for design: Design1 is 29
Voting has stopped for design: Design2
Final vote count for design: Design2 is 28
Voting has stopped for design: Design3
Final vote count for design: Design3 is 26

*/