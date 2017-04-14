package com.education.java.concurrency.readwritelock;

public class MinimumCollectionReader implements Runnable {

    private NonThreadSafeCollectionHolder collectionHolder;

    public MinimumCollectionReader(NonThreadSafeCollectionHolder collectionHolder) {
        this.collectionHolder = collectionHolder;
    }

    @Override
    public void run() {
        System.out.println("A minimum value is " + collectionHolder.findMin());
    }
}
