package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double avgGrade) {
        for (Student student: students
             ) {
            if (student.getAverageGrade() == avgGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithHighestAverageGrade() {
        Student studentWithHighestAVGGrade = students.get(0);
        for (Student student: students
             ) {
            if (student.getAverageGrade() > studentWithHighestAVGGrade.getAverageGrade())
                studentWithHighestAVGGrade = student;
        }
        return studentWithHighestAVGGrade;
    }

    public Student getStudentWithLowestAverageGrade() {
        Student studentWithLowestAVGGrade = students.get(0);
        for (Student student: students
        ) {
            if (student.getAverageGrade() < studentWithLowestAVGGrade.getAverageGrade())
                studentWithLowestAVGGrade = student;
        }
        return studentWithLowestAVGGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}