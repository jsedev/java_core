package com.education.java.concurrency.locks.incorrect;

public class TotalMoneyCounterOperation implements Runnable {

    private User user;

    private BankVault bankVault;

    public TotalMoneyCounterOperation(User user, BankVault bankVault) {
        this.user = user;
        this.bankVault = bankVault;
    }

    @Override
    public void run() {

        calculateTotalSum();
    }

    private void calculateTotalSum() {

        int totalSum = user.getMoney() + bankVault.getTotalAmount();
        System.out.println("Total money sum: " + totalSum);
    }
}
