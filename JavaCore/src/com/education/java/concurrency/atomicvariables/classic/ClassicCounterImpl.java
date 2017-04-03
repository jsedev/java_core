package com.education.java.concurrency.atomicvariables.classic;

import com.education.java.concurrency.atomicvariables.Counter;

public class ClassicCounterImpl implements Counter {

    private int count;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public int getValue() {
        return count;
    }
}
