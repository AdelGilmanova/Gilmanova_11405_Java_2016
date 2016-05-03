package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.HomeWorkRepository;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class HomeWorkServiceTest {
    @InjectMocks
    private static HomeWorkService homeWorkService;
    @Mock
    private static HomeWorkRepository homeWorkRepository;

    @Test
    public void getAllClassesShouldBeRight() {
        Assert.assertEquals(homeWorkRepository.getHomeWorksByClassId(1), homeWorkService.getHomeWorksByClassId(1));
    }
}
