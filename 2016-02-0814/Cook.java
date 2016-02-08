import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Cook implements Cookable{
    private String FIO;
    private Schedule schedule;
    private Double workExperience;

    @Override
    public void takeOrder(StudentsClass studentsClass, Date time, int amount) {

    }

    @Override
    public void cooking(Date time, String ingredients) {

    }

    @Override
    public void giveOrder(StudentsClass studentsClass, Date time, int amount) {

    }
}
