package com.codegym.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Find the class by its description

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clazz: Collections.class.getDeclaredClasses()
             ) {
            if (Modifier.isPrivate(clazz.getModifiers()) &&
                    Modifier.isStatic(clazz.getModifiers()) &&
                    List.class.isAssignableFrom(clazz)) {
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    List list = (List) constructor.newInstance();
                    list.get(0);
                }catch (IndexOutOfBoundsException caught) {
                    return clazz;
                }catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ignore) {
                }

            }
        }
        return null;
    }
}
