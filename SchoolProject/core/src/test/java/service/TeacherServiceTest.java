package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.TeacherRepository;
import ru.kpfu.itis.Gilmanova.repository.jpa.TeacherRepositoryJPA;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TeacherServiceTest {
    @InjectMocks
    private static TeacherService teacherService;
    @Mock
    private static TeacherRepository teachersRepository;
    @Mock
    private static TeacherRepositoryJPA teacherRepositoryJPA;

    @Test
    public void getTeacherShouldBeRight() {
        Assert.assertEquals(teacherRepositoryJPA.getTeacherById(1), teacherService.getTeacher(1));
    }

    @Test
    public void getTeacherByUserIdShouldBeRight() {
        Assert.assertEquals(teachersRepository.getTeacherByUserId(1), teacherService.getTeacherByUserId(1));
    }

    @Test
    public void getAllTeachersShouldBeRight() {
        Assert.assertEquals(teachersRepository.getAllTeachers(), teacherService.getAllTeachers());
    }

    @Test
    public void getTeacherByNameShouldBeRight() {
        Assert.assertEquals(teachersRepository.getTeacherByName(""), teacherService.getTeacherByName(""));
    }

    @Test
    public void addClassShouldBeRight() {
        Assert.assertEquals(teachersRepository.checkTeacher_Object(1, 1), teacherService.addClass(1, 1, 1));
    }

    @Test
    public void addObjectShouldBeRight() {
        Assert.assertEquals(teachersRepository.checkClass_Teacher(1, 1, 1), teacherService.addObject(1, 1));
    }

}
