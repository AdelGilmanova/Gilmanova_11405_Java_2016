package secutiry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class MyUserDetailTest {
    @InjectMocks
    private static MyUserDetail myUserDetail;
    @Mock
    private static UsersEntity userEntity;

    @Test
    public void getPasswordShouldBeRight(){
        Assert.assertEquals(userEntity.getHashPass(), myUserDetail.getPassword());
    }

    @Test
    public void getUsernameShouldBeRight(){
        Assert.assertEquals(userEntity.getUsername(), myUserDetail.getUsername());
    }

    @Test
    public void isAccountNonExpiredShouldBeRight(){
        Assert.assertEquals(true, myUserDetail.isAccountNonExpired());
    }

    @Test
    public void isAccountNonLockedShouldBeRight(){
        Assert.assertEquals(true, myUserDetail.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpiredShouldBeRight(){
        Assert.assertEquals(true, myUserDetail.isCredentialsNonExpired());
    }

    @Test
    public void isEnabledShouldBeRight(){
        Assert.assertEquals(userEntity.getEnable(), myUserDetail.isEnabled());
    }

    @Test
    public void getUserEntity(){
        Assert.assertEquals(userEntity, myUserDetail.getUserEntity());
    }

}
