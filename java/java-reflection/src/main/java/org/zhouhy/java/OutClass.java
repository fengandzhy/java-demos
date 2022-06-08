package org.zhouhy.java;

public class OutClass {
    private void print() {
        System.out.println("Calling the OutClass print method" );
    }

    class InnerClass {

        private void print() {
            System.out.println("Calling the InnerClass print method" );
        }
    }

    private class InnerClass1 {

        private void print() {
            System.out.println("Calling the InnerClass1 print method" );
        }
    }

    private class InnerClass2 {

        private void print() {
            System.out.println("Calling the InnerClass2 print method" );
        }
    }
}
