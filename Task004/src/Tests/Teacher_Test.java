package Tests;

import Classes.Student;
import Classes.StudentsClass;
import Classes.Subject;
import Classes.Teacher;
import Interfaces.Studentable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Teacher_Test {
    public static Teacher teacher;
    private static Subject subject;
    private static Studentable student;
    private static StudentsClass studentsClass;

    @BeforeClass
    public static void createTeacher() {
        teacher = new Teacher();
        subject = mock(Subject.class);
        student = mock(Student.class);
        studentsClass = mock(StudentsClass.class);
    }

    @Test
    public void deleteDataMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.deleteData(3, subject, (Student) student));
    }

    @Test
    public void saveDataMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.showData(3, subject, (Student) student));
    }

    @Test
    public void showDataMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.saveData(3, subject, (Student) student));
    }

    @Test
    public void expelMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.expel((Student) student, subject, 3));
    }

    @Test
    public void pullEstimateMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.pullEstimate(5, subject, (Student) student));
    }

    @Test
    public void teachMethodShouldBeRight() {
        Assert.assertEquals(true, teacher.teach(subject, studentsClass, 72));
    }
}