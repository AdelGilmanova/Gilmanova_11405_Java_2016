package ru.kpfu.itis.java.Gilmanova.interfaces;

import ru.kpfu.itis.java.Gilmanova.classes.Student;
import ru.kpfu.itis.java.Gilmanova.classes.Subject;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Journalable {
    boolean saveData(int data, Subject subject, Student student);
    boolean deleteData(int data, Subject subject, Student student);
    boolean showData(int data, Subject subject, Student student);
}
