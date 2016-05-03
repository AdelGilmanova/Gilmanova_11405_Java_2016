package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.UsersRepository;
import ru.kpfu.itis.Gilmanova.service.UsersService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UsersServiceTest {
    @InjectMocks
    private static UsersService usersService;
    @Mock
    private static UsersRepository usersRepository;

    @Test
    public void getUserShouldBeRight() {
        Assert.assertEquals(usersRepository.getUser(""), usersService.getUser(""));
    }
}
