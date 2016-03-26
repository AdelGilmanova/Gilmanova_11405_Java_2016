package Classes;

/**
 * Created by Adel on 08.02.2016.
 */
public class Schedule {
    private StudentsClass studentsClass;
    private String weekday;
    private Subject subject;

    public Schedule(StudentsClass studentsClass, String weekday, Subject subject) {
        this.studentsClass = studentsClass;
        this.weekday = weekday;
        this.subject = subject;
    }

    public Schedule(){    }

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }

    public String getWeekday() {
        return weekday;
    }

    public Subject getSubject() {
        return subject;
    }

}
