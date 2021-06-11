package com.codegym.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Adding a file to an archive

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFileName = args[1];
        File file = new File(fileName);
        ZipEntry zipEntry;
        Map<String, ByteArrayOutputStream> allFiles = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName))) {

            while ((zipEntry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream builder = new ByteArrayOutputStream();
                int size;
                while((size = zis.read(buffer)) != -1) {
                    builder.write(buffer, 0, size);
                }
                allFiles.put(zipEntry.getName(), builder);
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            for (Map.Entry<String, ByteArrayOutputStream> entry : allFiles.entrySet()
                    ) {
                if(entry.getKey().substring(entry.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zos.putNextEntry(new ZipEntry(entry.getKey()));
                zos.write(entry.getValue().toByteArray());
                //Files.copy(entry.getValue(), zos);
            }
            ZipEntry zipEntry1 = new ZipEntry("new/" + file.getName());
            zos.putNextEntry(zipEntry1);
            Files.copy(file.toPath(), zos);
        }


    }
}
