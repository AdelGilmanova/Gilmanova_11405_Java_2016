package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;

/**
 * Created by Adel on 30.04.2016.
 */
public class ObjectsEntityTest {
    private static ObjectsEntity objectsEntity;

    @BeforeClass
    public static void create() {
        objectsEntity = new ObjectsEntity("");
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, objectsEntity.getId());
    }

    @Test
    public void getObjectShouldNotReturnNull() {
        Assert.assertEquals("", objectsEntity.getObject());
    }

}
