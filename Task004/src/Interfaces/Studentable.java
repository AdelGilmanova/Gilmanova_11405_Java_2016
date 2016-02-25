package Interfaces;

import Classes.Diary;
import Classes.StudentsClass;
import Classes.Subject;
import Classes.Teacher;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public interface Studentable {
    boolean setEstimate(int estimate, Teacher teacher, Diary diary);
    boolean goToLessons(Subject subject, Date time, StudentsClass studentsClass);
    boolean doClassWork(Subject subject, Date time, int amount);
}
