package com.education.java.concurrency.readwritelock;

import java.util.Random;

public class CollectionPopulator implements Runnable {

    private NonThreadSafeCollectionHolder collectionHolder;

    private Random random;

    public CollectionPopulator(NonThreadSafeCollectionHolder collectionHolder) {

        random = new Random();

        this.collectionHolder = collectionHolder;
    }

    @Override
    public void run() {

        int newValue = random.nextInt(100);

        collectionHolder.addValue(newValue);

        System.out.println("Nex value was added to collection: " + newValue);
    }
}
