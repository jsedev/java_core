package com.education.java.concurrency.condition;

public class StorePopulator implements Runnable {

    private Store store;

    public StorePopulator(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        store.addNewItems("penñil");

        System.out.println("Store was populated.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        store.lock();
        try {

            String item = store.sellItem("penñil").orElseGet(String::new);
            System.out.println("StorePopulator bought: " + item);

        } finally {
            store.unlock();
        }

    }
}
