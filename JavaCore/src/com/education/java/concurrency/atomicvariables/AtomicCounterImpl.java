package com.education.java.concurrency.atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterImpl implements Counter {

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public int getValue() {
        return counter.intValue();
    }
}
