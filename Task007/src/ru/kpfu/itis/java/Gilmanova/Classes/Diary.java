package ru.kpfu.itis.java.Gilmanova.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
@Qualifier("diary")
public class Diary {
    @Autowired
    @Qualifier("valiev")
    private Student student;
    @Autowired
    private List<Subject> subjectList;
    @Autowired
    private Schedule schedule;

    public Diary() {
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