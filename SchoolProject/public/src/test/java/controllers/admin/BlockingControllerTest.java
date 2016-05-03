package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.admin.BlockingController;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class BlockingControllerTest {
    @InjectMocks
    private static BlockingController blockingController;
    @Mock
    private static StudentService studentService;
    @Mock
    private static TeacherService teacherService;

    @Test
    public void blockStudentShouldBeRight() {
        Assert.assertEquals("redirect:/admin/students_list", blockingController.blockStudent("1"));
    }

    @Test
    public void unblockStudentShouldBeRight() {
        Assert.assertEquals("redirect:/admin/students_list", blockingController.unblockStudent("1"));
    }

    @Test
    public void blockTeacherShouldBeRight() {
        Assert.assertEquals("redirect:/admin/teacher_list", blockingController.blockTeacher("1"));
    }

    @Test
    public void unblockTeacherShouldBeRight() {
        Assert.assertEquals("redirect:/admin/teacher_list", blockingController.unblockTeacher("1"));
    }


}
