package Classes;

import java.util.ArrayList;

/**
 * Created by Adel on 08.02.2016.
 */
public class Diary {
    private Student student;
    private ArrayList<Subject> subjectList;
    private Schedule schedule;

    public Diary(Student student, ArrayList<Subject> subjectList, Schedule schedule) {
        this.student = student;
        this.subjectList = subjectList;
        this.schedule = schedule;
    }

    public Diary() {
    }

    public Student getStudent() {
        return student;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
