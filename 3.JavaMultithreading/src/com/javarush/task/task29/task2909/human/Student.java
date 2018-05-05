package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }



    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double val) {
        setAverageGrade(getAverageGrade() + val);
    }

    public void setAverageGrade(double value) {
        averageGrade = value;
    }

    public void setCourse(int value) {
        course = value;
    }

    public int getCourse() {
        return course;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getPosition() {
        return "Студент";
    }
}