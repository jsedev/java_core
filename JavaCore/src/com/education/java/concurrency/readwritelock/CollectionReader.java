package com.education.java.concurrency.readwritelock;

public class CollectionReader implements Runnable {

    private NonThreadSafeCollectionHolder collectionHolder;

    public CollectionReader(NonThreadSafeCollectionHolder collectionHolder) {
        this.collectionHolder = collectionHolder;
    }

    @Override
    public void run() {
        collectionHolder.printCollection();
    }
}
