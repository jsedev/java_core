package com.education.java.concurrency.atomicvariables.classic;

import java.util.stream.IntStream;

import com.education.java.concurrency.atomicvariables.Counter;

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
