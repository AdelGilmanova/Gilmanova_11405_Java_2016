package ru.kpfu.itis.java.Gilmanova.interfaces;

import ru.kpfu.itis.java.Gilmanova.classes.Diary;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.classes.Subject;
import ru.kpfu.itis.java.Gilmanova.classes.Teacher;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Studentable {
    boolean setEstimate(int estimate, Teacher teacher, Diary diary);
    boolean goToLessons(Subject subject, Date time, StudentsClass studentsClass);
    boolean doClassWork(Subject subject, Date time, int amount);
}
