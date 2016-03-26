package Tests;

import Classes.Journal;
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
public class Journal_Test {
    private static Journalable journal;
    private static Subject subject;
    private static Studentable student;

    @BeforeClass
    public static void createJournal(){
        journal = new Journal();
        subject = mock(Subject.class);
        student = mock(Student.class);
    }

    @Test
    public void deleteDataMethodShouldBeRight() {
        Assert.assertEquals(true, journal.deleteData(3, subject, (Student) student));
    }

    @Test
    public void showDataMethodShouldBeRight() {
        Assert.assertEquals(true, journal.saveData(3, subject, (Student) student));
    }

    @Test
    public void saveDataMethodShouldBeRight() {
        Assert.assertEquals(true, journal.showData(3, subject, (Student) student));
    }
}
