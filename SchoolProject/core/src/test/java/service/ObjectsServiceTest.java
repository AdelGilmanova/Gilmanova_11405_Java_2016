package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.ObjectsRepository;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ObjectsServiceTest {
    @InjectMocks
    private static ObjectsService objectsService;
    @Mock
    private static ObjectsRepository objectsRepository;

    @Test
    public void getAllClassesShouldBeRight() {
        Assert.assertEquals(objectsRepository.getObjects(1), objectsService.getObjects(1));
    }

    @Test
    public void getAllObjectsShouldBeRight() {
        Assert.assertEquals(objectsRepository.getAllObjects(), objectsService.getAllObjects());
    }

    @Test
    public void getObjectShouldBeRight() {
        Assert.assertEquals(objectsRepository.getObject(1), objectsService.getObject(1));
    }
}
