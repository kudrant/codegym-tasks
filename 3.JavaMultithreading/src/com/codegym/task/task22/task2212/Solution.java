package com.codegym.task.task22.task2212;

/* 
Phone number verification

*/
public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {
        //check for null and empty
        if (phoneNumber == null || phoneNumber.equals(""))
            return false;
        if (phoneNumber.matches("\\w"))
            return false;

        int length = phoneNumber.replaceAll("[^0-9]","").length();

        if(length == 12){
            //validate phone numbers of format "+380501234567"
            if (phoneNumber.matches("^(?!\\+.*\\(.*\\).*\\-\\-.*$)(?!\\+.*\\(.*\\).*\\-$)(([0-9]{0,6})?([-]{0,1})?([0-9]{0,4})?(\\+[0-9]{2,8})?([-0-9]{0,1})?([0-9]{0,2})?([-0-9]{0,1})?([0-9]{0,2})?(\\([0-9]{3})?(\\)[0-9]{7})?)$"))
                return true;

        } else if(length == 10){
            // check for 10 digit number
            if (phoneNumber.matches("^(?!\\+.*\\(.*\\).*\\-\\-.*$)(?!\\+.*\\(.*\\).*\\-$)(([0-9]{0,6})?([-]{0,1})?([0-9]{0,4})?(\\+[0-9]{2,8})?([-0-9]{0,1})?([0-9]{0,2})?([-0-9]{0,1})?([0-9]{0,2})?(\\([0-9]{3})?(\\)[0-9]{7})?)$"))
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("null - " + checkPhoneNumber(null));
        System.out.println("nothing - " + checkPhoneNumber(""));
        System.out.println("+380501234567 - " + checkPhoneNumber("+380501234567"));
        System.out.println("+38(050)1234567 - " + checkPhoneNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - " + checkPhoneNumber("+38050123-45-67"));
        System.out.println("050123-4567 - " + checkPhoneNumber("050123-4567"));
        System.out.println("+38)050(1234567 - " + checkPhoneNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - " + checkPhoneNumber("+38(050)1-23-45-6-7"));
        System.out.println("050xxx4567 - " + checkPhoneNumber("050xxx4567"));
        System.out.println("050123456 - " + checkPhoneNumber("050123456"));
        System.out.println("(0)501234567 - " + checkPhoneNumber("(0)501234567"));
       // System.out.println(" - " + checkPhoneNumber(""));
      //  System.out.println(" - " + checkPhoneNumber(""));




    }
}
