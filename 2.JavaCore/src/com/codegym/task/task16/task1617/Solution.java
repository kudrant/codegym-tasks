package com.codegym.task.task16.task1617;

/* 
Countdown at the races

*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //write your code here
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //write your code here
            try {
                while (!interrupted()) {
                    if (numSeconds > 0){
                        System.out.print(numSeconds + " ");
                    }
                    else {
                        System.out.print("Go!");
                        break;
                    }
                    numSeconds--;
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                System.out.print("Interrupted!");
            }
        }
    }
}
