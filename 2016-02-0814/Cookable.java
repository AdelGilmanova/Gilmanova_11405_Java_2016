import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Cookable {
    void takeOrder(StudentsClass studentsClass, Date time, int amount);
    void cooking(Date time, String ingredients);
    void giveOrder(StudentsClass studentsClass, Date time, int amount);
}
