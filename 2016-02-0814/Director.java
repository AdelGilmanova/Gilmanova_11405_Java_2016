import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Director implements Directorable, Teacherable{
    private String FIO;
    private Subject subject;
    private Double workExperience;

    @Override
    public void dismiss(Teacher teacher, String cause) {

    }

    @Override
    public void changeWages(Teacher teacher, double wages) {

    }

    @Override
    public void spendLine(StudentsClass studentsClass, Date date, int amount) {

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
