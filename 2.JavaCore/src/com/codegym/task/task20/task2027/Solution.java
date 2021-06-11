package com.codegym.task.task20.task2027;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/* 
Word search

*/
public class Solution {
    public static void main(String[] args) {
//        int[][] wordSearch = new int[][]{
//                //0    1    2    3    4    5    6
//                {'e', 'd', 'e', 'r', 'e', 'k', 'x'},// 0
//                {'u', 'n', 'n', 'n', 'e', 'o', 'd'},// 1
//                {'e', 'n', 'g', 'n', 'e', 'v', 'z'},// 2
//                {'m', 'n', 'n', 'n', 'r', 'h', 'w'},// 3
//                {'e', 'o', 'e', 'e', 'e', 'a', 'c'},// 4
//                {'u', 'r', 'a', 'm', 'a', 'r', 'd'},// 5
//                {'l', 'n', 'a', 'a', 'a', 'a', 'z'},// 6
//                {'m', 'r', 'p', 'r', 'a', 'r', 'w'},// 7
//                {'p', 'o', 'e', 'q', 's', 'a', 'c'},// 8
//                {'f', 'd', 'e', 'r', 'a', 'a', 'x'},// 9
//        };
//        detectAllWords(wordSearch, "gne");


        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'a', 'r', 'o', 'v'},
                {'m', 'l', 'e', 'm', 'o', 'h'},
                {'p', 'o', 'e', 'e', 'e', 'j'}
        };
        detectAllWords(wordSearch, "home", "same");
        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {
        int maxY = wordSearch.length - 1;
        int maxX = wordSearch[0].length - 1;
        Word currentWord;
        List<Word> findedWords = new ArrayList<>();


        for (String word: words
             ) { // →↓←↑ + diagonals

            //char[] currentWordChars = word.toCharArray();
            int wordLength = word.length();
            char firstChar = word.charAt(0);
            for (int y = 0; y <= maxY; y++) {
                for (int x = 0; x <= maxX; x++) {
                    if (wordSearch[y][x] == firstChar) {
                        // start search

                        int charIndex = 1;
                        // checking right →
                        if (x + wordLength <= maxX) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            for (int x1 = x + 1; x1 < x + wordLength; x1++) {
                                if (wordSearch[y][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking down ↓
                        charIndex = 1;
                        if (y + wordLength <= maxY) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            for (int y1 = y + 1; y1 < y + wordLength; y1++) {
                                if (wordSearch[y1][x] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking left ←
                        charIndex = 1;
                        if (x - wordLength + 1 >= 0) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            for (int x1 = x - 1; x1 > x - wordLength; x1--) {
                                if (wordSearch[y][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking up ↑
                        charIndex = 1;
                        if (y - wordLength + 1 >= 0) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            for (int y1 = y - 1; y1 > y - wordLength; y1--) {
                                if (wordSearch[y1][x] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking diagonal right up
                        charIndex = 1;
                        if (x + wordLength - 1 <= maxX && y - wordLength + 2 >= 0) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            int y1 = y;
                            for (int x1 = x + 1; x1 < x + wordLength; x1++) {
                                y1--;
                                if (wordSearch[y1][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking diagonal right down
                        charIndex = 1;
                        if (x + wordLength - 1 <= maxX && y + wordLength - 1 <= maxY) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            int y1 = y;
                            for (int x1 = x + 1; x1 < x + wordLength; x1++) {
                                y1++;
                                if (wordSearch[y1][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking diagonal left down
                        charIndex = 1;
                        if (x - wordLength + 2 >= 0 && y + wordLength - 1<= maxY) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            int y1 = y;
                            for (int x1 = x - 1; x1 > x - wordLength; x1--) {
                                y1++;
                                if (wordSearch[y1][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }

                        // checking diagonal left up
                        charIndex = 1;
                        if (x - wordLength + 2 >= 0 && y - wordLength + 2 >= 0) {
                            currentWord = new Word(word);
                            currentWord.setStartPoint(x, y);
                            int y1 = y;
                            for (int x1 = x - 1; x1 > x - wordLength; x1--) {
                                y1--;
                                if (wordSearch[y1][x1] == word.charAt(charIndex)) {
                                    charIndex++;
                                }
                                else break;
                                if (charIndex == wordLength) {
                                    currentWord.setEndPoint(x1, y1);
                                    findedWords.add(currentWord);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Word word: findedWords
             ) {
            System.out.println(word);
        }
        return findedWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
