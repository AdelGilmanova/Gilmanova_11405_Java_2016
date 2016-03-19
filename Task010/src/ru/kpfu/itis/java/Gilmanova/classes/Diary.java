package ru.kpfu.itis.java.Gilmanova.classes;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
public class Diary {
    private Student student;
    private List<Subject> subjectList;
    private Schedule schedule;

    public Diary() {
    }

    public Diary(Student student, List<Subject> subjectList, Schedule schedule) {
        this.student = student;
        this.subjectList = subjectList;
        this.schedule = schedule;
    }

    public Student getStudent() {
        return student;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Diary{" +
                ", subjectList=" + subjectList +
                ", schedule=" + schedule +
                '}';
    }
}
