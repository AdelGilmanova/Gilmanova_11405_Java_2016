package ru.kpfu.itis.java.Gilmanova.Classes;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
public class StudentsClass {
    private String name;
    private List<Student> students;
    private Teacher teacher;

    public StudentsClass() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudentsClass{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
