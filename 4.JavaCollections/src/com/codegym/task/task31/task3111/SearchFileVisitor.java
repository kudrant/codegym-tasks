package com.codegym.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean resultFlag = true;
        byte[] content = Files.readAllBytes(file); // File size: content.length
        String strContent = new String(content);


        if (partOfName != null)
            resultFlag = file.getFileName().toString().contains(partOfName);
        if (partOfContent != null && resultFlag)
            resultFlag = strContent.contains(partOfContent);
        if (maxSize != 0 && minSize != 0 && resultFlag)
            resultFlag = (long)content.length < maxSize && (long)content.length > minSize;
        else if (maxSize != 0 && resultFlag)
            resultFlag = (long) content.length < maxSize;
        else if (minSize != 0 && resultFlag)
            resultFlag = (long) content.length > minSize;

        if (resultFlag)
            foundFiles.add(file);
        
        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
}
