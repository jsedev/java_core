package com.education.java.concurrency.readwritelock;

public class PrintAllCollectionReader implements Runnable {

    private NonThreadSafeCollectionHolder collectionHolder;

    public PrintAllCollectionReader(NonThreadSafeCollectionHolder collectionHolder) {
        this.collectionHolder = collectionHolder;
    }

    @Override
    public void run() {
        collectionHolder.printCollection();
    }
}
