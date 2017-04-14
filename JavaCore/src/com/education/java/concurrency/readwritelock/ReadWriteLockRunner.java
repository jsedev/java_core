package com.education.java.concurrency.readwritelock;

public class ReadWriteLockRunner {

    private static final NonThreadSafeCollectionHolder collectionHolder;

    private static final MaximumCollectionReader maxCollectionReader;

    private static final Thread maxReaderThread;

    private static final MinimumCollectionReader minCollectionReader;

    private static final Thread minReaderThread;

    private static final CollectionPopulator collectionPopulator;

    private static final Thread collectionPopulatorThread1;

    private static final Thread collectionPopulatorThread2;

    static {

        collectionHolder = new NonThreadSafeCollectionHolder();

        maxCollectionReader = new MaximumCollectionReader(collectionHolder);
        maxReaderThread = new Thread(maxCollectionReader);

        minCollectionReader = new MinimumCollectionReader(collectionHolder);
        minReaderThread = new Thread(minCollectionReader);

        collectionPopulator = new CollectionPopulator(collectionHolder);
        collectionPopulatorThread1 = new Thread(collectionPopulator);
        collectionPopulatorThread2 = new Thread(collectionPopulator);
    }

    public static void main(String[] args) throws InterruptedException {

        maxReaderThread.start();
        minReaderThread.start();

        collectionPopulatorThread1.start();
        collectionPopulatorThread2.start();
    }
}
