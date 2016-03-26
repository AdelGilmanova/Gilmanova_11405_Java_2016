package Tests;

import Classes.Start;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Adel on 23.02.2016.
 */
public class Start_Test {
    private static Start start;

    @BeforeClass
    public static void createStart() throws IOException {
        start = new Start();
    }

    @Test(expected = Exception.class)
    public void startMethodShouldBeWorkRight(){
        start.start();
    }

    @Test(expected = IOException.class)
    public void createStartFrameMethodShouldBeWorkRight() throws IOException {
        start.createStartFrame("localhost");
    }
    @Test(expected = IOException.class)
    public void mainMethodShouldBeRight() throws IOException {
        Start.main(null);
    }
}
