package Classes;

import Interfaces.Journalable;

/**
 * Created by Adel on 08.02.2016.
 */
public class Casebook implements Journalable {
    private StudentsClass studentsClass;
    private Schedule schedule;
    private int missingNumber;

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
}
