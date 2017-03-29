package com.education.java.concurrency.atomicvariables;

import java.util.stream.IntStream;

public class IncrementerThread extends Thread {

    private Counter counter;

    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, 10000).forEach(i -> {
            counter.increment();
        });
    }
}
