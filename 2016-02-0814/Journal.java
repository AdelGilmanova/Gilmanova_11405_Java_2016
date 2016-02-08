import java.util.ArrayList;

/**
 * Created by Adel on 08.02.2016.
 */
public class Journal implements Journalable {
    private Teacher teacher;
    private StudentsClass studentsClass;
    private ArrayList<Subject> subjectList;

    @Override
    public void saveEstimate(int estimate, Subject subject, Student student) {

    }

    @Override
    public void deleteEstimate(int estimate, Subject subject, Student student) {

    }

    @Override
    public void showEstimate(int estimate, Subject subject, Student student) {

    }
}
