package com.codegym.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Unzipping a file

*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        int size = args.length;
        List<String> fileNamePart = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            fileNamePart.add(args[i]);
        }
        Collections.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        try {
            for (String filePart : fileNamePart
            ) {
                fisList.add(new FileInputStream(filePart));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        Enumeration<FileInputStream> fisEnum = Collections.enumeration(fisList);

        try (SequenceInputStream sis = new SequenceInputStream(fisEnum);
             ZipInputStream zis = new ZipInputStream(sis);
             FileOutputStream fos = new FileOutputStream(resultFileName)) {

            byte[] buffer = new byte[1024];

            while (zis.getNextEntry() != null) {
                int count;
                while ((count = zis.read(buffer)) != -1)
                    fos.write(buffer, 0, count);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
