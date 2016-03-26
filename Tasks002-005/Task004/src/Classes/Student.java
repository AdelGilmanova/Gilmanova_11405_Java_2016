package Classes;

import Interfaces.Studentable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Student implements Studentable {
    private String FIO;
    private Diary diary;
    private StudentsClass studentsClass;

    @Override
    public boolean setEstimate(int estimate, Teacher teacher, Diary diary) {
        return estimate != 0 && teacher != null && diary!=null;
    }

    @Override
    public boolean goToLessons(Subject subject, Date time, StudentsClass studentsClass) {
        return subject != null;
    }

    @Override
    public boolean doClassWork(Subject subject, Date time, int amount) {
        return subject != null;
    }
}
