package com.codegym.task.task20.task2026;

/*
Rectangle algorithms

*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Must be 5");
    }

    public static int getRectangleCount(byte[][] a) {
        int sizeY = a.length;
        int sizeX = a[0].length;
        int count = 0;

        for (int y = 0; y < sizeX; y++) {
            Rectangle currentRectangle = null;
            for (int x = 0; x < sizeY; x++) {
                if (a[y][x] == 2)
                    continue;
                if (a[y][x] == 1 && currentRectangle == null) {
                    currentRectangle = new Rectangle(x, y, x, y);
                    count++;
                    continue;
                }
                if (a[y][x] == 0 && currentRectangle != null) {
                    currentRectangle.setX2(x - 1);
                    int y2check = y;
                    while (a[y2check][x-1] != 0 && y2check < sizeY - 1) {
                        y2check++;
                    }
                    currentRectangle.setY2(y2check);
                    fillRectangle(currentRectangle, a);
                    currentRectangle = null;
                }
            }

        }
        return count;
    }

    public static void fillRectangle(Rectangle rec, byte[][] matrix) {
        for (int y = rec.getY1(); y <= rec.getY2(); y++) {
            for (int x = rec.getX1(); x <= rec.getX2(); x++) {
                matrix[y][x] = 2;
            }
        }

    }

    public static class Rectangle {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }


        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
    }
}
