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

        while (true) {

            boolean isLocked = false;

            try {

                isLocked = lock.tryLock();

                if (isLocked) {
                    return userBackpackMoney + userBankVaultMoney;
                } else {
                    System.out.println("Get total character wealth is locked...");
                    // process other resources
                }

            } finally {
                if (isLocked) {
                    lock.unlock();
                }
            }
        }
    }

    public void performGoldTransfer() {

        while (true) {

            boolean isLocked = false;

            try {

                isLocked = lock.tryLock();

                if (isLocked) {

                    int amountToTransfer = userBackpackMoney;
                    userBackpackMoney = 0;

                    Thread.sleep(2000);

                    userBankVaultMoney += amountToTransfer;
                    break;

                } else {
                    System.out.println("Perform gold transfer is locked...");
                    // process other resources
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (isLocked) {
                    lock.unlock();
                }
            }
        }
    }
}
