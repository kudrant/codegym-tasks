package com.codegym.task.task12.task1217;

/* 
Fly, run and swim
Write public CanFly, CanRun, and CanSwim interfaces.
Add one method to each interface.


Requirements:
1. The Solution class must have a CanFly interface.
2. The Solution class must have a CanRun interface.
3. The Solution class must have a CanSwim interface.
4. The CanFly interface must have one method.
5. The CanRun interface must have one method.
6. The CanSwim interface must have one method.

*/

public class Solution {
    public static void main(String[] args) {

    }
    // Add interfaces here
    public interface CanFly {
        void fly(int height);
    }

    public interface CanRun {
        void run(int length);
    }
    public interface CanSwim {
        void swim(int distance);
    }

}
