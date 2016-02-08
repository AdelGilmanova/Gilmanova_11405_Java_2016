import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Student implements Studentable{
    private String FIO;
    private Diary diary;
    private StudentsClass studentsClass;

    @Override
    public void getEstimate(int estimate, Teacher teacher) {

    }

    @Override
    public void goToLessons(Subject subject, Date time, StudentsClass studentsClass) {

    }

    @Override
    public void doClassWork(Subject subject, Date time, int amount) {

    }
}
