package com.education.java.concurrency.readwritelock;

public class MaximumCollectionReader implements Runnable {

    private NonThreadSafeCollectionHolder collectionHolder;

    public MaximumCollectionReader(NonThreadSafeCollectionHolder collectionHolder) {
        this.collectionHolder = collectionHolder;
    }

    @Override
    public void run() {
        System.out.println("A maximum value is " + collectionHolder.findMax());
    }

}
