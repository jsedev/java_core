package com.education.java.defaultmethods;

public interface Beta extends Alpha {

    default void printString() {
        // super.printString(); illegal because 'super' belongs to an object.

        Alpha.super.printString(); // correct
    }

}
