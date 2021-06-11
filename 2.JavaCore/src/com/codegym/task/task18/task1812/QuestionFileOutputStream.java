package com.codegym.task.task18.task1812;

import java.io.*;

/* 
Extending AmigoOutputStream

*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;


    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.original = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        original.flush();

    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);

    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you really want to close the stream? Y/N");
        String answer = reader.readLine();
        if (answer.equals("Y")) {
            original.close();
        }
        reader.close();

    }
}

