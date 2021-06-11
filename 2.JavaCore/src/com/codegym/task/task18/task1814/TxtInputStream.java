package com.codegym.task.task18.task1814;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
UnsupportedFileName

*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream original;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (fileName.endsWith(".txt")) {
            new FileInputStream(fileName);
        }
        else {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {
    }
}

