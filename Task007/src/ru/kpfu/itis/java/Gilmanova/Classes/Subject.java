package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.kpfu.itis.java.Gilmanova.interfaces.Teacherable;

/**
 * Created by Adel on 08.02.2016.
 */
public class Subject {
    private String profile;

    @Autowired
    private Teacherable teacher;

    @Value("32")
    private int hours;

    public Subject() {}

    public String getProfile() {
        return profile;
    }

    public Teacherable getTeacher() {
        return teacher;
    }

    public int getHours() {
        return hours;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setTeacher(Teacherable teacher) {
        this.teacher = teacher;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "profile='" + profile + '\'' +
                ", hours=" + hours +
                '}';
    }
}
