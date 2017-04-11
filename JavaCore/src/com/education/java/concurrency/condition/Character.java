package com.education.java.concurrency.condition;

public class Character implements Runnable {

    private Store store;

    private String item;

    public Character(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        String itemToBuy = "penñil";

        store.lock();

        try {

            boolean isItemAvailable = store.isItemAvailable(itemToBuy);

            if (!isItemAvailable) {

                System.out.println("A " + itemToBuy + " is not available in store.");

                store.getBlockingPoolA().await();
            }

            item = store.sellItem(itemToBuy).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            store.unlock();
        }

        System.out.println("Character bought next item: " + item);
    }
}
