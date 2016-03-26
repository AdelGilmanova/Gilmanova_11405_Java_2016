package ru.kpfu.itis.java.Gilmanova.interfaces;


import ru.kpfu.itis.java.Gilmanova.classes.Student;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.classes.Subject;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Teacherable {
    boolean teach(Subject subject, StudentsClass studentsClass, int hours);
    boolean expel(Student student, Subject subject, int estimate);
    boolean pullEstimate(int estimate, Subject subject, Student student);
}
