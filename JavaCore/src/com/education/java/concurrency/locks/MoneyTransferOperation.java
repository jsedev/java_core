package com.education.java.concurrency.locks;

public class MoneyTransferOperation implements Runnable {

    private Count count;

    public MoneyTransferOperation(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

        count.performGoldTransfer();
    }
}
