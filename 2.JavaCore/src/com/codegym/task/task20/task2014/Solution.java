package com.codegym.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution

*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("file.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution savedObject = new Solution(26);
        outputStream.writeObject(savedObject);
        fileOutput.close();
        outputStream.close();

        Solution savedObject1 = new Solution(30);

        FileInputStream fiStream = new FileInputStream("file.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object loadedObject = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        savedObject1 = (Solution) loadedObject;
        System.out.println(savedObject.string);
        System.out.println(savedObject1.string);
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
