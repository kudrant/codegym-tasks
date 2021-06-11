package com.codegym.task.task31.task3113;

import java.awt.event.WindowFocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
What's in the folder?

*/
public class Solution {
    int totalFolders = -1;
        int totalFiles = 0;
        int totalSize = 0;


    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = reader.readLine();
        reader.close();

        Path path;

        if (!Files.isDirectory(Paths.get(pathStr))) {
            System.out.println(pathStr + " is not a folder");

        }
        else {
            path = Paths.get(pathStr);
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    solution.totalFolders++;
                    return FileVisitResult.CONTINUE ;
                }

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    solution.totalFiles++;
                    solution.totalSize += basicFileAttributes.size();
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Total folders: " + solution.totalFolders);
            System.out.println("Total files: " + solution.totalFiles);
            System.out.println("Total size: " + solution.totalSize);
        }
    }


}
