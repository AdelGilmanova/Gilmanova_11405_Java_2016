/**
 * Created by Adel on 08.02.2016.
 */
public class Teacher implements Teacherable, Journalable{
    private String FIO;
    private Subject subject;
    private Double workExperience;

    @Override
    public void saveData(int data, Subject subject, Student student) {

    }

    @Override
    public void deleteData(int data, Subject subject, Student student) {

    }

    @Override
    public void showData(int data, Subject subject, Student student) {

    }

    @Override
    public void teach(Subject subject, StudentsClass studentsClass, int hours) {

    }

    @Override
    public void expel(Student student, Subject subject, int estimate) {

    }

    @Override
    public void pullEstimate(int estimate, Subject subject, Student student) {

    }
}
