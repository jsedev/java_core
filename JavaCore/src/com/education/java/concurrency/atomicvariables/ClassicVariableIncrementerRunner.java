package com.education.java.concurrency.atomicvariables;

public class ClassicVariableIncrementerRunner {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        IncrementerThread it1 = new IncrementerThread(counter);
        IncrementerThread it2 = new IncrementerThread(counter);

        it1.start();
        it2.start();

        it1.join();
        it2.join();

        System.out.println("Counter: " + counter.getCount());
    }
}
