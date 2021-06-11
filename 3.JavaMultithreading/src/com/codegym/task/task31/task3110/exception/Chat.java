package com.codegym.task.task31.task3110.exception;

public class Chat {
    int id;
    String name;
    int testStep;

    public Chat(int id, String name, int testStep) {
        this.id = id;
        this.name = name;
        this.testStep = testStep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTestStep() {
        return testStep;
    }

    public void setTestStep(int testStep) {
        this.testStep = testStep;
    }
}
