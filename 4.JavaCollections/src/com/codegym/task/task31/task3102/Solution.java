package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;


/* 
Find all the files

*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootPath = new File(root);
        ArrayList<String> resultList = new ArrayList<>();
        Queue<File> tree = new PriorityQueue<>();

        Collections.addAll(tree, rootPath.listFiles());

        while(!tree.isEmpty()) {
            File currentFile = tree.remove();
            if(currentFile.isDirectory())
                Collections.addAll(tree, currentFile.listFiles());
            else
                resultList.add(currentFile.getAbsolutePath());
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}