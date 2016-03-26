package Tests;

import Classes.StudentsClass;
import Classes.Teacher;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class StudentsClass_Test {
    private static StudentsClass studentsClass;
    private static StudentsClass studentsClass1;
    private static ArrayList list;
    private static Teacher teacher;

    @BeforeClass
    public static void createStudentsClass() {
        list = mock(ArrayList.class);
        teacher = mock(Teacher.class);
        studentsClass = new StudentsClass(list, teacher, list);
        studentsClass1 = new StudentsClass();
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(list, studentsClass.getSubjectList());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(list, studentsClass.getStudents());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(teacher, studentsClass.getTeacher());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null, studentsClass1.getSubjectList());
        Assert.assertEquals(null, studentsClass1.getStudents());
        Assert.assertEquals(null, studentsClass1.getTeacher());
    }
}
