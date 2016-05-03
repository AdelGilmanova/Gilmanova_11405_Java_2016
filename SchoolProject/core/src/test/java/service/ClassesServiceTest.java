package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.ClassesRepository;
import ru.kpfu.itis.Gilmanova.repository.jpa.ClassesRepositoryJPA;
import ru.kpfu.itis.Gilmanova.service.ClassesService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ClassesServiceTest {
    @InjectMocks
    private static ClassesService classesService;
    @Mock
    private static ClassesRepository classesRepository;
    @Mock
    private static ClassesRepositoryJPA classesRepositoryJPA;

    @Test
    public void getAllClassesShouldBeRight() {
        Assert.assertEquals(classesRepository.getAllClasses(), classesService.getAllClasses());
    }

    @Test
    public void getClassesShouldBeRight() {
        Assert.assertEquals(classesRepository.getClasses(1), classesService.getClasses(1));
    }

    @Test
    public void getClazzShouldBeRight() {
        Assert.assertEquals(classesRepositoryJPA.getClassById(1), classesService.getClazz(1));
    }
}
