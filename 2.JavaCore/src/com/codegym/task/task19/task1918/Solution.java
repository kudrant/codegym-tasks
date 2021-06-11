package com.codegym.task.task19.task1918;

/* 
Introducing tags

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        String tagOpen = "<" + args[0];
        String tagClose = "</" + args[0] + ">";
        String html = "";


        FileReader fileReader = new FileReader(fileName);

        bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
             html += bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();

        int beginTagString;
        int nextOpeningTagIndex = 0;
        int nextClosingTagIndex = 0;
        int endTagString;
        ArrayList<Integer> openingList = new ArrayList<>();
        ArrayList<Integer> closingList = new ArrayList<>();
        while (true) {  // collecting positions of opening and closing tags
            beginTagString = html.indexOf(tagOpen, nextOpeningTagIndex);
            endTagString = html.indexOf(tagClose, nextClosingTagIndex);
            if (endTagString <= 0)
                break;
            openingList.add(beginTagString);
            nextOpeningTagIndex = beginTagString + 1;

            closingList.add(endTagString);
            nextClosingTagIndex = endTagString + 2;


         }
        int opTagPosition;
        int clTagPosition = 0;
        int clTagIndex = 0;
        for (int i = 0; i < openingList.size(); i++) {
            opTagPosition = openingList.get(i); //selecting opening tag one by one
            for (int k = 0; k < closingList.size(); k++) { //looking for nearest closing tag
                if (closingList.get(k) > opTagPosition) {
                    clTagPosition = closingList.get(k);
                    clTagIndex = k;
                    break;
                }
            }
            int openingTagCount = 0; // counting opening tags before closing tag
            for (int j = i ; j < openingList.size(); j++) {
                if (openingList.get(j) < clTagPosition) {
                    openingTagCount++; //counting the number of opening tags between the current opening tag and the nearest closing tag
                }
                else break;
            }

            System.out.println(html.substring(opTagPosition, closingList.get(clTagIndex + openingTagCount - 1) + tagClose.length()));
        }

    }
}
