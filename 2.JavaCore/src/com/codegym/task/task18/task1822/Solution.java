package com.codegym.task.task18.task1822;

/* 
Finding data inside a file

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private static final boolean DEBUG = true;
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            if (DEBUG) {
                fileName = "C:/test4.txt";
            } else {
                fileName = reader.readLine();
            }
            reader.close();
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));
            String strCurrentLine;
            HashMap<Integer, FileRecordItem> map = new HashMap<>();
            while ((strCurrentLine = buffReader.readLine()) != null) {
                int id;
                String productName = "";
                double price;
                int quantity;

                String[] currentLineItems = strCurrentLine.split(" ");
                int size = currentLineItems.length;
                id = Integer.parseInt(currentLineItems[0]);
                price = Double.parseDouble(currentLineItems[size - 2]);
                quantity = Integer.parseInt(currentLineItems[size - 1]);

                String[] productNameArray = Arrays.copyOfRange(currentLineItems, 1, size - 2);
                for (int i = 0; i < productNameArray.length; i++) {
                    productName += productNameArray[i];
                    if (i == productNameArray.length - 1)
                        break;
                    productName += " ";
                }
                map.put(id, new FileRecordItem(id, productName, price, quantity));
            }
            buffReader.close();
            int argID = Integer.parseInt(args[0]);
            FileRecordItem selected = map.get(argID);
            System.out.println(selected.getId() + " " + selected.getProductName() + " " + selected.getPrice() + " " + selected.getQuantity());

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }



    private static class FileRecordItem {
        private int id;
        private String productName;
        private double price;
        private int quantity;

        public FileRecordItem(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
