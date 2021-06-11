package com.codegym.task.task14.task1408;

/* 
Chicken factory

*/

import javax.swing.text.html.HTMLWriter;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Continent.AFRICA);
        hen.getMonthlyEggCount();
    }

    static class HenFactory {

        static Hen getHen(String continent) {
            Hen hen = null;
            //write your code here

            switch (continent) {
                case "Europe":
                    hen = new EuropeanHen();
                    break;
                case "North America":
                    hen = new NorthAmericanHen();
                    break;
                case "Asia":
                    hen = new AsianHen();
                    break;
                case "Africa":
                    hen = new AfricanHen();
                    break;
                default:
                    break;
            }

            return hen;
        }
    }
}



