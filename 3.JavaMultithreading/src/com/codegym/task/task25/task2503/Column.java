package com.codegym.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Specifies a new column display order, which is saved in the realOrder array.
     * realOrder[enum index] = display order; -1, if the column is not displayed.
     *
     * @param newOrder new order for displaying the columns in the table
     * @throws IllegalArgumentException if a column is repeated
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Calculates and returns the list of columns to display in a configurable order (see the configureColumns method)
     * Uses the realOrder.
     *
     * @return list of columns
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        //find column name sequence
        //input :  amount, amountNumber, BankName
        //base on Column ordinal , amount value = 3, amountNumber value = 2, BN value = 1;
        // from example the realorder should be [-1, 2, 1, 0] -1 means not exist, BN third input, AN second input, Amount first input
        for(int i = 0; i < realOrder.length; i++) {
            for (int j = 0; j < realOrder.length; j++) {  //according sequence find correspond value and add to result list.
                if (i == realOrder[j]) {
                    result.add(Column.values()[j]);
                }
            }
        }
        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {

        if (realOrder[this.ordinal()] == -1)
            return false;
        return true;
    }

    @Override
    public void hide() {
        Column.realOrder[this.ordinal()] = -1;

    }
}
