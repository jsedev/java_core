package com.education.java.concurrency.atomicvariables.classic;

public class VariableIncrementerRunner {

    public static void main(String[] args) throws InterruptedException {

        ClassicCounterImpl counter = new ClassicCounterImpl();

        IncrementerThread it1 = new IncrementerThread(counter);
        IncrementerThread it2 = new IncrementerThread(counter);

        it1.start();
        it2.start();

        it1.join();
        it2.join();

        System.out.println("Counter: " + counter.getValue());
    }
}
