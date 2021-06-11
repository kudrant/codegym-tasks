package com.codegym.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            // do something here
            synchronized (mail) {
            mail.setText("Person [" + name + "] wrote an email 'AAA'");
            mail.notify();
            }
            // do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
