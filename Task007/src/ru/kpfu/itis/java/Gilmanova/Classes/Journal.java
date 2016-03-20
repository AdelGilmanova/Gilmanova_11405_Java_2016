package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.java.Gilmanova.interfaces.Journalable;

import java.util.List;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
public class Journal implements Journalable {
    @Autowired
    @Qualifier("teacher")
    private Teacher teacher;

    @Autowired
    private StudentsClass studentsClass;

    @Autowired
    private List<Subject> subjectList;

    public Journal() {
    }

    @Override
    public boolean saveData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    @Override
    public boolean deleteData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    @Override
    public boolean showData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentsClass(StudentsClass studentsClass) {
        this.studentsClass = studentsClass;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "teacher=" + teacher +
                ", studentsClass=" + studentsClass +
                ", subjectList=" + subjectList +
                '}';
    }
}
