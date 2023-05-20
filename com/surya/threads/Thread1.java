package com.surya.threads;

public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("In Thread.");
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
        System.out.println("In Thread. Iteration: " + i);
        }
    }
}
