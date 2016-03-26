package Tests;

import Classes.Casebook;
import Classes.Student;
import Classes.Subject;
import Interfaces.Journalable;
import Interfaces.Studentable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Casebook_Test {
    private static Journalable casebook;
    private static Subject subject;
    private static Studentable student;

    @BeforeClass
    public static void createCasebook() {
        casebook = new Casebook();
        subject = mock(Subject.class);
        student = mock(Student.class);
    }

    @Test
    public void deleteDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.deleteData(3, subject, (Student) student));
    }

    @Test
    public void saveDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.saveData(3, subject, (Student) student));
    }

    @Test
    public void showDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.showData(3, subject, (Student) student));
    }
}
