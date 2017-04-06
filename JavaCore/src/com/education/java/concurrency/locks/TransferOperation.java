package com.education.java.concurrency.locks;

public class TransferOperation implements Runnable {

    private User user;

    private BankVault bankVault;

    public TransferOperation(User user, BankVault bankVault) {

        this.user = user;
        this.bankVault = bankVault;
    }

    @Override
    public void run() {

        transferMoney();
    }

    private void transferMoney() {

        int amount = user.getMoney();
        user.setMoney(0);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalAmount = bankVault.getTotalAmount() + amount;
        bankVault.setTotalAmount(totalAmount);
    }
}
