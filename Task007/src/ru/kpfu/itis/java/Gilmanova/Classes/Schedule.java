package ru.kpfu.itis.java.Gilmanova.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
public class Schedule {
    @Autowired
    private StudentsClass studentsClass;
    @Value("monday")
    private String weekday;
    @Autowired
    private List<Subject> subjectList;

    public Schedule(){    }

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setStudentsClass(StudentsClass studentsClass) {
        this.studentsClass = studentsClass;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "studentsClass=" + studentsClass +
                ", weekday='" + weekday + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
