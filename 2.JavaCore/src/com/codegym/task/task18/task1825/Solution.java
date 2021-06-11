package com.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Building a file

*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        String lastFileName = "";
        FileInputStream fis = null;
        FileOutputStream fos;
        Map<Integer, byte[]> map = new TreeMap<>();
        try {
            while (!(fileName = reader.readLine()).equals("end")) {
                fis = new FileInputStream(fileName);
                byte[] buffer = new byte[fis.available()];
                String partNo = fileName.substring(fileName.indexOf(".part") + 5, fileName.length());
                fis.read(buffer);
                map.put(Integer.parseInt(partNo), buffer);
                lastFileName = fileName;
                fis.close();
            }
            String outputFileName = lastFileName.substring(0, lastFileName.indexOf(".part"));
            File file = new File(outputFileName);
            file.createNewFile();
            fos = new FileOutputStream(outputFileName);
            for (Map.Entry<Integer, byte[]> entry: map.entrySet()
                 ) {
                fos.write(entry.getValue());
            }
            fos.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
