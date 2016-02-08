import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Studentable {
    void getEstimate(int estimate, Teacher teacher);
    void goToLessons(Subject subject, Date time, StudentsClass studentsClass);
    void doClassWork(Subject subject, Date time, int amount);
}
