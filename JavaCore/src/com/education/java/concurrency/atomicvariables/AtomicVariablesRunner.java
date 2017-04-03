package com.education.java.concurrency.atomicvariables;

import com.education.java.concurrency.atomicvariables.classic.IncrementerThread;

public class AtomicVariablesRunner {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new AtomicCounterImpl();
        IncrementerThread it1 = new IncrementerThread(counter);
        IncrementerThread it2 = new IncrementerThread(counter);

        it1.start();
        it2.start();

        it1.join();
        it2.join();

        System.out.println("Atomic counter: " + counter.getValue());
    }
}
