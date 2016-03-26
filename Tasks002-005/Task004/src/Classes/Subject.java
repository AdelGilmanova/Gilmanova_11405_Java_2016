package Classes;

/**
 * Created by Adel on 08.02.2016.
 */
public class Subject {
    private String profile;
    private Teacher teacher;
    private int hours;

    public Subject(String profile, Teacher teacher, int hours) {
        this.profile = profile;
        this.teacher = teacher;
        this.hours = hours;
    }

    public Subject() {
    }

    public String getProfile() {
        return profile;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getHours() {
        return hours;
    }
}
