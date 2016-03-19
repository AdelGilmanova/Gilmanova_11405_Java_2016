package ru.kpfu.itis.java.Gilmanova.classes;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
public class Schedule {
    private StudentsClass studentsClass;
    private String weekday;
    private List<Subject> subjectList;

    public Schedule(){    }

    public Schedule(StudentsClass studentsClass, String weekday, List<Subject> subjectList) {
        this.studentsClass = studentsClass;
        this.weekday = weekday;
        this.subjectList = subjectList;
    }

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
