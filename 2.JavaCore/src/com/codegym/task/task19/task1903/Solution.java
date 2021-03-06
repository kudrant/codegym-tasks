package com.codegym.task.task19.task1903;

/* 
Adapting multiple interfaces

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();
    static  {
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR", "France");
    }

    public static void main(String[] args) {
//        String code = "1";
//        String phoneNo = Integer.toString(991234567);
//        while (phoneNo.length() < 10) {
//            phoneNo = "0" + phoneNo;
//        }
//        String prefix = phoneNo.substring(0, 3);
//        String threeDig = phoneNo.substring(3, 6);
//        String twoDig1 = phoneNo.substring(6, 8);
//        String twoDig2 = phoneNo.substring(8, 10);
//        String result =  code + "(" + prefix + ")" + threeDig + "-" + twoDig1 + "-" + twoDig2;
//        System.out.println(result);
    }



    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String code = Integer.toString(this.data.getCountryPhoneCode());
            String phoneNo = Integer.toString(this.data.getPhoneNumber());
            while (phoneNo.length() < 10) {
                phoneNo = "0" + phoneNo;
            }
            String prefix = phoneNo.substring(0, 3);
            String threeDig = phoneNo.substring(3, 6);
            String twoDig1 = phoneNo.substring(6, 8);
            String twoDig2 = phoneNo.substring(8, 10);
            return "+" + code + "(" + prefix + ")" + threeDig + "-" + twoDig1 + "-" + twoDig2;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        // For example: US

        String getCompany();            // For example: CodeGym Ltd.

        String getContactFirstName();   // For example: John

        String getContactLastName();    // For example: Smith

        int getCountryPhoneCode();      // For example: 1

        int getPhoneNumber();           // For example: 991234567
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.

        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Smith, John

        String getPhoneNumber();        // For example: +1(099)123-45-67
    }
}