package Classes;

import Interfaces.Cookable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Cook implements Cookable {
    private String FIO;
    private Schedule schedule;
    private Double workExperience;

    public Cook() {
    }

    @Override
    public boolean takeOrder(StudentsClass studentsClass, Date time, int amount) {
        return studentsClass != null && amount != 0;
    }

    @Override
    public boolean cooking(Date time, String ingredients, Schedule schedule) {
        return ingredients != null;
    }

    @Override
    public boolean giveOrder(StudentsClass studentsClass, Date time, int amount) {
        return studentsClass != null && amount != 0;
    }
}
