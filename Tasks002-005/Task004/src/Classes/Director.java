package Classes;

import Interfaces.Directorable;
import Interfaces.Teacherable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Director implements Directorable, Teacherable {
    private String FIO;
    private Subject subject;
    private Double workExperience;

    @Override
    public boolean dismiss(Teacher teacher, String cause) {
        return teacher != null;
    }

    @Override
    public boolean changeWages(Teacher teacher, double wages) {
        return teacher != null && wages > 5000;
    }

    @Override
    public boolean spendLine(StudentsClass studentsClass, Date date, int amount) {
        return studentsClass != null && amount > 10;
    }

    @Override
    public boolean teach(Subject subject, StudentsClass studentsClass, int hours) {
        return subject != null && studentsClass != null && hours != 0;
    }

    @Override
    public boolean expel(Student student, Subject subject, int estimate) {
        return student != null && subject != null;
    }

    @Override
    public boolean pullEstimate(int estimate, Subject subject, Student student) {
        return student != null && subject != null;
    }
}
