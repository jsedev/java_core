package com.education.java.defaultmethods;

public class DefaultMethodsInheritanceImpl implements Beta {

    public void printString() {

        Beta.super.printString(); // the same is here. No super.printString().
                                  // Otherwise a compile error appears.
    }
}
