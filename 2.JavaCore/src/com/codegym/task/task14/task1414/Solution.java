package com.codegym.task.task14.task1414;

/* 
MovieFactory

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Read several keys (strings) from the console. Item 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> allowedKeys = new ArrayList<>();
        allowedKeys.add("cartoon");
        allowedKeys.add("thriller");
        allowedKeys.add("soapOpera");
        String key = null;
        while(true) {
            key = reader.readLine();
            Movie movie = MovieFactory.getMovie(key);
            if (!(allowedKeys.contains(key)))
                break;
            System.out.println(movie.getClass().getSimpleName());
        }

        /*
            8. Create a variable movie in the Movie class, and for each entered string (key):
            8.1. Get an object using MovieFactory.getMovie and assign it to the variable movie.
            8.2. Display the result of calling movie.getClass().getSimpleName().
        */


    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            switch (key) {
                case ("cartoon"):
                    movie = new Cartoon();
                    break;
                case ("soapOpera"):
                    movie = new SoapOpera();
                    break;
                case ("thriller"):
                    movie = new Thriller();
                    break;
            }

            //write your code here. Items 5, 6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    // Write your classes here. Item 3
    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie {

    }

}
