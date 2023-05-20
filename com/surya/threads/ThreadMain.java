package com.surya.threads;

public class ThreadMain {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        t1.start();
       
        // System.out.println("Main is Exiting");
    }
}