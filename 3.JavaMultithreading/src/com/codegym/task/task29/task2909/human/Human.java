package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    private List<Human> children = new ArrayList<>();

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Human() {
    }

    public class Size {
        public int height;
        public int weight;

    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human childToAdd) {
        children.add(childToAdd);
    }

    public void removeChild(Human childToRemove) {
        children.remove(childToRemove);
    }

    protected Size size;
    private BloodType bloodType;

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }


    public String getPosition() {
        return "Person";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void live() {

   }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Height: " + size.height + " Weight: " + size.weight);
    }
}