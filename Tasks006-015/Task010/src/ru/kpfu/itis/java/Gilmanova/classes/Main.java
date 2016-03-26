package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.interfaces.Cookable;
import ru.kpfu.itis.java.Gilmanova.interfaces.Journalable;
import ru.kpfu.itis.java.Gilmanova.interfaces.Studentable;

import java.util.Date;

/**
 * Created by Adel on 08.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Teacher teacher = (Teacher) ac.getBean("teacher");
        Director director = (Director) ac.getBean("director");
        Studentable student = (Student) ac.getBean("student");
        Cookable cook = (Cook) ac.getBean("cook");
        Journalable journal = (Journal) ac.getBean("journal");
        Journalable casebook = (Casebook) ac.getBean("casebook");
        StudentsClass studentsClass = (StudentsClass) ac.getBean("studentsClass");
        Subject subject = (Subject) ac.getBean("history");
        Schedule schedule = (Schedule) ac.getBean("schedule");
        Diary diary = (Diary) ac.getBean("diary");
        Date date = new Date();

        System.out.println(director.changeWages(teacher, 50000));
        System.out.println(director.dismiss(teacher, "Опоздание"));
        System.out.println(director.expel((Student) student, subject, 2));
        System.out.println(director.pullEstimate(5, subject, (Student) student));
        System.out.println(director.spendLine(studentsClass, date, 100));
        System.out.println(director.teach(subject, studentsClass, 72));

        System.out.println(teacher.deleteData(2, subject, (Student) student));
        System.out.println(teacher.saveData(5, subject, (Student) student));
        System.out.println(teacher.showData(4, subject, (Student) student));
        System.out.println(teacher.pullEstimate(5, subject, (Student) student));
        System.out.println(teacher.teach(subject, studentsClass, 32));
        System.out.println(teacher.expel((Student) student, subject, 4));

        System.out.println(journal.deleteData(2, subject, (Student) student));
        System.out.println(journal.saveData(5, subject, (Student) student));
        System.out.println(journal.showData(4, subject, (Student) student));

        System.out.println(casebook.deleteData(3, subject, (Student) student));
        System.out.println(casebook.saveData(4, subject, (Student) student));
        System.out.println(casebook.showData(5, subject, (Student) student));

        System.out.println(student.doClassWork(subject, date, 4));
        System.out.println(student.setEstimate(5, teacher, diary));
        System.out.println(student.goToLessons(subject, date, studentsClass));

        System.out.println(cook.cooking(date, "jjslnlskf", schedule));
        System.out.println(cook.giveOrder(studentsClass, date, 25));
        System.out.println(cook.takeOrder(studentsClass, date, 25));
    }
}
