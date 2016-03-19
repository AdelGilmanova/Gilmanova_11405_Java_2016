package ru.kpfu.itis.java.Gilmanova.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.java.Gilmanova.Interfaces.Cookable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
public class Cook implements Cookable {
    @Value("Виктор Петрович Баринов")
    private String FIO;
    @Autowired
    private Schedule schedule;
    @Value("20")
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

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setWorkExperience(Double workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "FIO='" + FIO + '\'' +
                ", schedule=" + schedule +
                ", workExperience=" + workExperience +
                '}';
    }
}
