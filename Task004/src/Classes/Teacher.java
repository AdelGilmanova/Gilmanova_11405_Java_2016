package Classes;

import Interfaces.Journalable;
import Interfaces.Teacherable;

/**
 * Created by Adel on 08.02.2016.
 */
public class Teacher implements Teacherable, Journalable {
    private String FIO;
    private Subject subject;
    private Double workExperience;

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
