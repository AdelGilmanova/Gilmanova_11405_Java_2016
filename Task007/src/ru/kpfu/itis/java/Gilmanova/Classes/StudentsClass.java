package ru.kpfu.itis.java.Gilmanova.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
public class StudentsClass {
    @Value("11A")
    private String name;
    @Autowired
    private List<Student> students;
    @Autowired
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
