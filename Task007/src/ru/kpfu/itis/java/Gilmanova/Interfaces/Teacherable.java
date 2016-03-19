package ru.kpfu.itis.java.Gilmanova.Interfaces;

import ru.kpfu.itis.java.Gilmanova.Classes.Student;
import ru.kpfu.itis.java.Gilmanova.Classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.Classes.Subject;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Teacherable {
    boolean teach(Subject subject, StudentsClass studentsClass, int hours);
    boolean expel(Student student, Subject subject, int estimate);
    boolean pullEstimate(int estimate, Subject subject, Student student);
}
