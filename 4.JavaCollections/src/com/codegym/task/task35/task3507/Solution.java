package com.codegym.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
What is ClassLoader?

*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animalSet = new HashSet<>();
        File[] files = new File(pathToAnimals).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {

                String packageName = Solution.class.getPackage().getName() + ".data"; //some bed solution (Hardcore data)
                Class clazz = new AnimalClassLoader().loadClass(file.toPath(), packageName); //Loading class from path

                int score = 0;
                //find interface Animal
                Class[] interfaces = clazz.getInterfaces();
                for (Class interf : interfaces)
                    if (interf.getSimpleName().toString().equals("Animal")) {
                        score++;
                        break;
                    }

                //Find default constuctor
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors)
                    if (constructor.getParameterCount() == 0) {
                        score++;
                    }

                //if all ok, add to set
                if (score == 2)
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        animalSet.add(animal);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }

        return animalSet;
    }

    public static class AnimalClassLoader extends ClassLoader {
        public Class<?> loadClass(Path path, String packageName) {
            try {
                String filePath = path.getFileName().toString();
                String className = packageName + "." + filePath.substring(0, filePath.length() - ".class".length());
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
