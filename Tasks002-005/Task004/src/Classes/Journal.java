package Classes;

import Interfaces.Journalable;

import java.util.ArrayList;

/**
 * Created by Adel on 08.02.2016.
 */
public class Journal implements Journalable {
    private Teacher teacher;
    private StudentsClass studentsClass;
    private ArrayList<Subject> subjectList;


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
