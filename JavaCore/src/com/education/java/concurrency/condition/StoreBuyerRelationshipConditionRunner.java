package com.education.java.concurrency.condition;

public class StoreBuyerRelationshipConditionRunner {

    public static void main(String[] args) throws InterruptedException {

        Store store = new Store();

        Character character = new Character(store);
        Thread characterThread = new Thread(character);

        StorePopulator storePopulator = new StorePopulator(store);
        Thread storePopulatorThread = new Thread(storePopulator);

        characterThread.start();

        Thread.sleep(2000);

        storePopulatorThread.start();

        characterThread.join();
        storePopulatorThread.join();
    }
}
