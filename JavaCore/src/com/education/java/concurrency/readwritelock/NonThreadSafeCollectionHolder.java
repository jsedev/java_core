package com.education.java.concurrency.readwritelock;

import static java.util.stream.Collectors.toList;

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
        numbers.add(value);
    }

    public int findMax() {

        lock.readLock().lock();

        try {

            return numbers.stream().mapToInt(Integer::intValue).max().orElse(-1);

        } finally {
            lock.readLock().unlock();
        }
    }

    public int findMin() {

        lock.readLock().lock();

        try {

            return numbers.stream().mapToInt(Integer::intValue).min().orElse(-1);

        } finally {
            lock.readLock().unlock();
        }
    }

    public void printCollection() {

        System.out.println("Actual collection: " + numbers);
    }
}
