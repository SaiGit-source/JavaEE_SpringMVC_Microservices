package com.webinar;

public class VotingRunnable implements Runnable {
    private Design d;
    protected boolean doStop = false;

    public VotingRunnable(Design d) {
        this.d = d;
    }
// the moment the flag (doStop) becomes true, the thread will stop executing the run method and exit gracefully. This allows for a controlled shutdown of the thread without abruptly terminating it, which can help prevent resource leaks and ensure that any necessary cleanup is performed before the thread exits.
    @Override
    public void run() {
        while (!doStop) {
            // Simulate voting process
            System.out.println("Voting going on for design: " + d.getName());
            d.getVotes().add(1L); // 1 vote for a design per thread
            Double sleepFor = Math.random() * 2000; // Random sleep time between 0 and 2 seconds
            
            try {
                Thread.sleep(sleepFor.longValue()); // Simulate time taken for voting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
