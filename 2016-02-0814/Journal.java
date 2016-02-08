import java.util.ArrayList;

/**
 * Created by Adel on 08.02.2016.
 */
public class Journal implements Journalable {
    private Teacher teacher;
    private StudentsClass studentsClass;
    private ArrayList<Subject> subjectList;


    @Override
    public void saveData(int data, Subject subject, Student student) {

    }

    @Override
    public void deleteData(int data, Subject subject, Student student) {

    }

    @Override
    public void showData(int data, Subject subject, Student student) {

    }
}
