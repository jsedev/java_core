package com.education.java.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {

    private final Lock lock = new ReentrantLock();

    private int userBackpackMoney;

    private int userBankVaultMoney;

    public Count(int userBackpackMoney, int userBankVaultMoney) {

        this.userBackpackMoney = userBackpackMoney;
        this.userBankVaultMoney = userBankVaultMoney;
    }

    public int getTotalCharacterWealth() {

        lock.lock();

        try {

            return userBackpackMoney + userBankVaultMoney;

        } finally {
            lock.unlock();
        }
    }

    public void performGoldTransfer() {

        lock.lock();

        try {

            int amountToTransfer = userBackpackMoney;
            userBackpackMoney = 0;

            Thread.sleep(20000);

            userBankVaultMoney += amountToTransfer;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
