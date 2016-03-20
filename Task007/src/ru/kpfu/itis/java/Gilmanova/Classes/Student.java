package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.kpfu.itis.java.Gilmanova.interfaces.Studentable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */

public class Student implements Studentable {
    private String FIO;

    @Autowired
    @Qualifier("diary")
    private Diary diary;
    
    @Autowired
    private StudentsClass studentsClass;

    public Student() {
    }

    @Override
    public boolean setEstimate(int estimate, Teacher teacher, Diary diary) {
        return estimate != 0 && teacher != null && diary!=null;
    }

    @Override
    public boolean goToLessons(Subject subject, Date time, StudentsClass studentsClass) {
        return subject != null;
    }

    @Override
    public boolean doClassWork(Subject subject, Date time, int amount) {
        return subject != null;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }

    public void setStudentsClass(StudentsClass studentsClass) {
        this.studentsClass = studentsClass;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FIO='" + FIO + '\'' +
                ", diary=" + diary +
                ", studentsClass=" + studentsClass +
                '}';
    }
}
