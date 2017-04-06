package com.education.java.concurrency.locks;

public class MoneyTransferRunner {

    public static void main(String[] args) throws InterruptedException {

        Count count = new Count(10, 90);
        TotalWealthOperation totalWealthOperation = new TotalWealthOperation(count);
        MoneyTransferOperation moneyTransferOperation = new MoneyTransferOperation(count);

        Thread totalWealthThread = new Thread(totalWealthOperation);
        Thread moneyTransferThread = new Thread(moneyTransferOperation);

        moneyTransferThread.start();

        Thread.sleep(100);

        totalWealthThread.start();

        moneyTransferThread.join();
        totalWealthThread.join();

        System.out.println("Done");
    }
}
