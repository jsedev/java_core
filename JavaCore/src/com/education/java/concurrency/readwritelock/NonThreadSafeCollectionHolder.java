package com.education.java.concurrency.readwritelock;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class NonThreadSafeCollectionHolder {

    private List<Integer> numbers;

    private ReadWriteLock lock;

    public NonThreadSafeCollectionHolder() {

        lock = new ReentrantReadWriteLock();

        numbers = IntStream.range(50, 60).boxed().collect(toList());
    }

    public void addValue(int value) {

        lock.writeLock().lock();

        try {
            numbers.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int findMax() {

        lock.readLock().lock();

        try {

            return Collections.max(numbers);

        } finally {
            lock.readLock().unlock();
        }
    }

    public int findMin() {

        lock.readLock().lock();

        try {

            return Collections.min(numbers);

        } finally {
            lock.readLock().unlock();
        }
    }

    public void printCollection() {

        lock.readLock().lock();

        try {
            System.out.println("Actual collection: " + numbers);
        } finally {
            lock.readLock().unlock();
        }
    }
}
