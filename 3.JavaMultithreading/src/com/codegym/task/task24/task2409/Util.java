package com.codegym.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Armani, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Lucky, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKlein, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here

        abstract class AbstractJeans implements Jeans {
            protected int id;
            protected double price;
            protected int size;
            protected int length;

            public AbstractJeans(int id, int length, int size, double price) {
                this.id = id;
                this.price = price;
                this.size = size;
                this.length = length;
            }

            @Override
            public int getLength() { return length; }
            @Override
            public int getSize() { return size; }
            @Override
            public int getId() { return id; }
            @Override
            public double getPrice() { return price; }
            @Override
            public abstract String getTM();
            @Override
            public String toString() { //Levis{id=1, length=34, size=6, price=150.0}
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append("{id=").append(id).append(", ");
                sb.append("length=").append(length).append(", ");
                sb.append("size=").append(size).append(", ");
                sb.append("price=").append(price).append("}");

                return sb.toString();
            }
        }
        class Levis extends AbstractJeans {
            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }
            @Override
            public int getLength() { return 0; }
            @Override
            public int getSize() { return 0; }
            @Override
            public int getId() { return 0; }
            @Override
            public double getPrice() { return 0; }
            @Override
            public String getTM() { return null; }
        }

        class Armani extends AbstractJeans {
            public Armani(int id, int length, int size, double price) {
                super(id, length, size, price);
            }
            @Override
            public int getLength() { return 0; }
            @Override
            public int getSize() { return 0; }
            @Override
            public int getId() { return 0; }
            @Override
            public double getPrice() { return 0; }
            @Override
            public String getTM() { return null; }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Armani == company) {
                    jeans = new Armani(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Armani("Armani"),
        Lucky("Lucky"),
        CalvinKlein("Calvin Klein");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
