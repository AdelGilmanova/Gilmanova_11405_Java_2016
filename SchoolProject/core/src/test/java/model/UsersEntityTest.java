package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

/**
 * Created by Adel on 30.04.2016.
 */
public class UsersEntityTest {
    private static UsersEntity usersEntity;

    @BeforeClass
    public static void create() {
        usersEntity = new UsersEntity("", "", true, "");
    }

    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, usersEntity.getId());
    }

    @Test
    public void getUsernameShouldNotReturnNull() {
        Assert.assertEquals("", usersEntity.getUsername());
    }

    @Test
    public void getHashPassShouldNotReturnNull() {
        Assert.assertEquals("", usersEntity.getHashPass());
    }

    @Test
    public void getRoleShouldNotReturnNull() {
        Assert.assertEquals("", usersEntity.getRole());
    }

    @Test
    public void getEnableShouldNotReturnNull() {
        Assert.assertEquals(true, usersEntity.getEnable());
    }
}
