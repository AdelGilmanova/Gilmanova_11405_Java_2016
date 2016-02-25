package Interfaces;

import Classes.Student;
import Classes.Subject;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Journalable {
    boolean saveData(int data, Subject subject, Student student);
    boolean deleteData(int data, Subject subject, Student student);
    boolean showData(int data, Subject subject, Student student);
}
