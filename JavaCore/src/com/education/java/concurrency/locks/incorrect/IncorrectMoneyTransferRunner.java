package com.education.java.concurrency.locks.incorrect;

import com.education.java.concurrency.locks.BankVault;
import com.education.java.concurrency.locks.TotalMoneyCounterOperation;
import com.education.java.concurrency.locks.TransferOperation;
import com.education.java.concurrency.locks.User;

public class IncorrectMoneyTransferRunner {

    public static void main(String[] args) throws InterruptedException {

        User user = new User();
        user.setMoney(10);

        BankVault bankVault = new BankVault();
        bankVault.setTotalAmount(90);

        TransferOperation transferOperation = new TransferOperation(user, bankVault);
        TotalMoneyCounterOperation totalMoneyCounterOperation = new TotalMoneyCounterOperation(user, bankVault);

        Thread transferThread = new Thread(transferOperation);
        Thread totalMoneyCounterThread = new Thread(totalMoneyCounterOperation);

        transferThread.start();

        Thread.sleep(1000);

        totalMoneyCounterThread.start();
    }
}
