package com.codegym.task.task20.task2022;

import java.io.*;

/* 
Overriding serialization in a thread

*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }


//    Write the verification code yourself in the main method:
//            1) create an instance of the Solution class
//              2) write data to it (writeObject)
//              3) serialize the Solution class (writeObject(ObjectOutputStream out))
//            4) deserialize, get a new object
//              5) write data to the new object (writeObject)
//          6) verify that the file contains the data from Items 2 and 5


    public static void main(String[] args) throws IOException {
//        Solution solution = new Solution("test.txt");
//        String dataString = "asdfasdfasdf";
//        solution.writeObject(dataString);
//

    }
}
