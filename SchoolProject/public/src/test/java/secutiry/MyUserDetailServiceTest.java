package secutiry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.security.MyUserDetailService;
import ru.kpfu.itis.Gilmanova.service.UsersService;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class MyUserDetailServiceTest {
    @InjectMocks
    private static MyUserDetailService myUserDetailService;
    @Mock
    private static UsersService userService;
    @Mock
    private static UsersEntity usersEntity;

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameShouldBeRight(){
        when(userService.getUser(anyString())).thenReturn(null);
        Assert.assertEquals(new MyUserDetail(usersEntity), myUserDetailService.loadUserByUsername(""));
    }
}
