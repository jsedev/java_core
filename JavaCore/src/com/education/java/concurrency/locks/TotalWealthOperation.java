package com.education.java.concurrency.locks;

public class TotalWealthOperation implements Runnable {

    private Count count;

    public TotalWealthOperation(Count count) {

        this.count = count;
    }

    @Override
    public void run() {

        System.out.println("Total character's wealth: " + count.getTotalCharacterWealth());
    }

}
