package com.codegym.task.task20.task2021;

import java.io.*;

/* 
Serialization is prohibited

*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {


        public SubSolution() throws NotSerializableException {
            //throw new NotSerializableException();
        }

        private void writeObject(ObjectOutputStream out) throws IOException
        {
            throw new NotSerializableException();
        }

        // By implementing readObject method,
        // we can prevent
        // subclass from de-serialization
        private void readObject(ObjectInputStream in) throws IOException
        {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) {

    }
}
