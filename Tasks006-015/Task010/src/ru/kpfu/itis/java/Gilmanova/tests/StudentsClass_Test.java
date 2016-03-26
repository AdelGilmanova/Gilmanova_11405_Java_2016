package ru.kpfu.itis.java.Gilmanova.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.classes.Teacher;

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
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        list = mock(ArrayList.class);
        teacher = mock(Teacher.class);
        studentsClass = (StudentsClass) ac.getBean("studentsClass");
        studentsClass1 = (StudentsClass) ac.getBean("emptyStudentsClass");
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals("11A", studentsClass.getName());
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
        Assert.assertEquals(null, studentsClass1.getStudents());
        Assert.assertEquals(null, studentsClass1.getStudents());
        Assert.assertEquals(null, studentsClass1.getTeacher());
    }
}
