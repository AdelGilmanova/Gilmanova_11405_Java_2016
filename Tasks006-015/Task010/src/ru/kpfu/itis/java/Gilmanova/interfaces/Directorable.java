package ru.kpfu.itis.java.Gilmanova.interfaces;

import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.classes.Teacher;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Directorable {
    boolean dismiss(Teacher teacher, String cause);
    boolean changeWages(Teacher teacher, double wages);
    boolean spendLine(StudentsClass studentsClass, Date date, int amount);
}
