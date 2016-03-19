package ru.kpfu.itis.java.Gilmanova.interfaces;

import ru.kpfu.itis.java.Gilmanova.classes.Schedule;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Cookable {
    boolean takeOrder(StudentsClass studentsClass, Date time, int amount);
    boolean cooking(Date time, String ingredients, Schedule schedule);
    boolean giveOrder(StudentsClass studentsClass, Date time, int amount);
}
