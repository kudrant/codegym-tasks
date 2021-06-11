package com.codegym.task.task12.task1220;

/* 
Human class and CanRun and CanSwim interfaces
Write a public Human class, and public CanRun and CanSwim interfaces.
Add one method to each interface.
Add these interfaces to the Human class, but do not implement the methods.
Declare the Human class as abstract.


Requirements:
1. The Solution class must have a CanRun interface with only one method.
2. The Solution class must have a CanSwim interface with only one method.
3. The Solution class must have a Human class.
4. The Human class must implement the CanRun and CanSwim interfaces.
5. The Human class must be abstract.
6. The Human class should not have any methods.
*/

public class Solution {
    public static void main(String[] args) {

    }
    public interface CanRun {
        void run();
    }
    public interface CanSwim {
        void swim();
    }

    public abstract class Human implements CanRun, CanSwim{

    }

    // Add public interfaces and a public class here
}
