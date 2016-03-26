package ru.kpfu.itis.java.Gilmanova.classes;

import ru.kpfu.itis.java.Gilmanova.interfaces.Teacherable;

/**
 * Created by Adel on 08.02.2016.
 */
public class Subject {
    private String profile;
    private Teacherable teacher;
    private int hours;

    public Subject() {}

    public Subject(String profile, Teacherable teacher, int hours) {
        this.profile = profile;
        this.teacher = teacher;
        this.hours = hours;
    }

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
