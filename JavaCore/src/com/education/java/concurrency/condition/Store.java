package com.education.java.concurrency.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private ReentrantLock lock;

    private Condition blockingPoolA;

    private List<String> items;

    private List<String> poolOfOrderedItems;

    public Store() {

        lock = new ReentrantLock();
        blockingPoolA = lock.newCondition();

        items = new ArrayList<>();
        items.add("book");

        poolOfOrderedItems = new ArrayList<>();
    }

    public Optional<String> sellItem(String item) {

        String result = null;

        if (lock.isHeldByCurrentThread() && items.contains(item)) {

            result = items.stream().filter(item::equals).findAny().get();
            items.remove(result);

            if (poolOfOrderedItems.contains(result)) {
                poolOfOrderedItems.remove(result);
            }

            System.out.println("Item was sold: " + result);
        }

        return Optional.ofNullable(result);
    }

    public void addNewItems(String... newItems) {

        items.addAll(Arrays.asList(newItems));

        lock();

        try {

            if (poolOfOrderedItems.size() > 0
                    && poolOfOrderedItems.stream().filter(items::contains).findAny().isPresent()) {
                blockingPoolA.signalAll();
            }

        } finally {
            unlock();
        }
    }

    public boolean isItemAvailable(String item) {

        boolean isItemAvailable = items.contains(item);

        if (!isItemAvailable && !poolOfOrderedItems.contains(item)) {

            poolOfOrderedItems.add(item);
        }

        return isItemAvailable;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public Condition getBlockingPoolA() {
        return blockingPoolA;
    }
}
