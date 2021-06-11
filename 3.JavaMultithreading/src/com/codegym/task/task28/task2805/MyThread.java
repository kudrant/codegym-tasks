package com.codegym.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static int priority = 0;

    public MyThread() {
        setPriority(priorityIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(priorityIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(priorityIncrement());
    }

    public MyThread(String name) {
        super(name);
        setPriority(priorityIncrement());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(priorityIncrement());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(priorityIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(priorityIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(priorityIncrement());
    }

//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//        super(group, target, name, stackSize, inheritThreadLocals);
//        setPriority(priorityIncrement());
//    }

    private int priorityIncrement() {
        if (priority < 10) {
            priority++;
        }
        else
            priority = 1;
        return priority;
    }
}
