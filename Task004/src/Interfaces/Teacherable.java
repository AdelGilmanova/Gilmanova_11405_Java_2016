package Interfaces;

import Classes.Student;
import Classes.StudentsClass;
import Classes.Subject;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Teacherable {
    boolean teach(Subject subject, StudentsClass studentsClass, int hours);
    boolean expel(Student student, Subject subject, int estimate);
    boolean pullEstimate(int estimate, Subject subject, Student student);
}
