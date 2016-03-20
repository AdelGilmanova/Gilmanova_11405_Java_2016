package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.kpfu.itis.java.Gilmanova.interfaces.Journalable;
import ru.kpfu.itis.java.Gilmanova.interfaces.Teacherable;

/**
 * Created by Adel on 08.02.2016.
 */
public class Teacher implements Teacherable, Journalable {
    private String FIO;

    @Autowired
    @Qualifier("history")
    private Subject subject;

    private Double workExperience;

    public Teacher() {}

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

    @Override
    public boolean teach(Subject subject, StudentsClass studentsClass, int hours) {
        return subject != null && studentsClass != null && hours != 0;
    }

    @Override
    public boolean expel(Student student, Subject subject, int estimate) {
        return student != null && subject != null;
    }

    @Override
    public boolean pullEstimate(int estimate, Subject subject, Student student) {
        return student != null && subject != null;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Double workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "FIO='" + FIO + '\'' +
                ", subject=" + subject +
                ", workExperience=" + workExperience +
                '}';
    }
}
