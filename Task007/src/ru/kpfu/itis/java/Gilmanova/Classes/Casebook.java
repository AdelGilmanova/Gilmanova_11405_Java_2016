package ru.kpfu.itis.java.Gilmanova.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.java.Gilmanova.Interfaces.Journalable;

/**
 * Created by Adel on 08.02.2016.
 */
@Component
public class Casebook implements Journalable {
    @Autowired
    private StudentsClass studentsClass;
    @Autowired
    private Schedule schedule;
    @Value("12")
    private int missingNumber;

    public Casebook() {
    }

    @Override
    public boolean saveData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    @Override
    public boolean deleteData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    @Override
    public boolean showData(int data, Subject subject, Student student) {
        return subject != null && student != null;
    }

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }

    public void setStudentsClass(StudentsClass studentsClass) {
        this.studentsClass = studentsClass;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(int missingNumber) {
        this.missingNumber = missingNumber;
    }

    @Override
    public String toString() {
        return "Casebook{" +
                "studentsClass=" + studentsClass +
                ", schedule=" + schedule +
                ", missingNumber=" + missingNumber +
                '}';
    }
}