/**
 * Created by Adel on 08.02.2016.
 */
public class Teacher implements Teacherable, Journalable{
    private String FIO;
    private Subject subject;
    private Double workExperience;

    @Override
    public void saveEstimate(int estimate, Subject subject, Student student) {
        
    }

    @Override
    public void deleteEstimate(int estimate, Subject subject, Student student) {

    }

    @Override
    public void showEstimate(int estimate, Subject subject, Student student) {

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
