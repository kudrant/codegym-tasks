package com.codegym.task.task17.task1707;

public class IMF {

    private static IMF imf;
    private static boolean isCreated = false;
    public static IMF getFund() {
        //write your code here

        synchronized (IMF.class) {
            if (!isCreated) {
                imf = new IMF();
                isCreated = true;
            }
        }


        return imf;
    }

    private IMF() {
    }
}
