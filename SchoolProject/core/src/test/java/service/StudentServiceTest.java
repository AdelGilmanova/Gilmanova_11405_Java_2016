package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.StudentRepository;
import ru.kpfu.itis.Gilmanova.service.StudentService;

import static org.mockito.Matchers.anyString;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class StudentServiceTest {
    @InjectMocks
    private static StudentService studentService;
    @Mock
    private static StudentRepository studentRepository;

    @Test
    public void getStudentByUserIdShouldBeRight() {
        Assert.assertEquals(studentRepository.getStudentByUserId(1), studentService.getStudentByUserId(1));
    }

    @Test
    public void getStudentShouldBeRight() {
        Assert.assertEquals(studentRepository.getStudent(1), studentService.getStudent(1));
    }

    @Test
    public void getAllStudentsShouldBeRight() {
        Assert.assertEquals(studentRepository.getAllStudents(), studentService.getAllStudents());
    }

    @Test
    public void getStudentByClassShouldBeRight() {
        Assert.assertEquals(studentRepository.getStudentByClass(1), studentService.getStudentByClass(1));
    }

    @Test
    public void getStudentByNameShouldBeRight() {
        Assert.assertEquals(studentRepository.getStudentByName(anyString()), studentService.getStudentByName(""));
    }
}
