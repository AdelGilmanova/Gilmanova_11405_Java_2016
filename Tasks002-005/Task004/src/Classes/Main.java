package Classes;

import Interfaces.Cookable;
import Interfaces.Journalable;
import Interfaces.Studentable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Director director = new Director();
        Studentable student = new Student();
        Cookable cook = new Cook();
        Journalable journal = new Journal();
        Journalable casebook = new Casebook();
        StudentsClass studentsClass = new StudentsClass();
        Subject subject = new Subject();
        Schedule schedule = new Schedule();
        Diary diary = new Diary();
        Date date = new Date();

        director.changeWages(teacher, 50000);
        director.dismiss(teacher, "Опоздание");
        director.expel((Student) student, subject, 2);
        director.pullEstimate(5, subject, (Student) student);
        director.spendLine(studentsClass, date, 100);
        director.teach(subject, studentsClass, 72);

        teacher.deleteData(2, subject, (Student) student);
        teacher.saveData(5, subject, (Student) student);
        teacher.showData(4, subject, (Student) student);
        teacher.pullEstimate(5, subject, (Student) student);
        teacher.teach(subject, studentsClass, 32);
        teacher.expel((Student) student, subject, 4);

        journal.deleteData(2, subject, (Student) student);
        journal.saveData(5, subject, (Student) student);
        journal.showData(4, subject, (Student) student);

        casebook.deleteData(3, subject, (Student) student);
        casebook.saveData(4, subject, (Student) student);
        casebook.showData(5, subject, (Student) student);

        student.doClassWork(subject, date, 4);
        student.setEstimate(5, teacher, diary);
        student.goToLessons(subject, date, studentsClass);

        cook.cooking(date, "jjslnlskf", schedule);
        cook.giveOrder(studentsClass, date, 25);
        cook.takeOrder(studentsClass, date, 25);
    }
}
