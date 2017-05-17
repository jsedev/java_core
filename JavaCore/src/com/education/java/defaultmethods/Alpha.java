package com.education.java.defaultmethods;

public interface Alpha {

    default void printString() {
        System.out.println("Alpha string");
    }
}
