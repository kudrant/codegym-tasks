package com.codegym.task.task17.task1709;

/* 
Proposals

*/

import java.util.ArrayList;

public class Solution {
    public volatile static int proposal = 0;

    public static void main(String[] args) {
//        new AcceptProposal().start();
//        new MakeProposal().start();

        ArrayList<String> list = new ArrayList<>();
        list.add("роза");
        list.add("лоза");
        list.add("лира");

        for (String word: fix(list)
             ) {
            System.out.println(word);
        }
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Made Proposal No. " + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("Accepted Proposal No." + proposal);
                    thisProposal = proposal;
                }
            }
        }
    }



    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String word = strings.get(i);
            if (word.contains("р") && word.contains("л"))
                continue;
            else if (word.contains("л")) {
                strings.add(i + 1, word);
                i++;
            }
            else if (word.contains("р")) {
                strings.remove(i);
                i--;
            }
        }


        return strings;
    }
}