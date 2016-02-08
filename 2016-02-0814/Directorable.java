import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Directorable {
    void dismiss(Teacher teacher, String cause);
    void changeWages(Teacher teacher, double wages);
    void spendLine(StudentsClass studentsClass, Date date, int amount);
}
