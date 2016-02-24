package Tests;

import Classes.OFrame;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class OFrame_Test {
    private static OFrame frame;

    @BeforeClass
    public static void createOFrame() throws IOException {
        frame = new OFrame("localhost", 10, "clientName");
        Socket socket = mock(Socket.class);
        when(frame.getSocket()).thenReturn(socket);
    }

    @Test(expected = Exception.class)
    public void createButtonsMethodShouldBeRight() {
        frame.createButtons();
    }

    @Test(expected = Exception.class)
    public void showFrameMethodShouldBeRight() {
        frame.showFrame(true);
    }

    @Test(expected = Exception.class)
    public void drawFrameMethodShouldBeRight() {
        frame.drawFrame();
    }

    @Test
    public void checkFieldMethodShouldBeRight() {
        Assert.assertEquals(true, frame.checkField(0, 0, "X"));
    }

    @Test(expected = IOException.class)
    public void printOnFrameMethodShouldBeRight() throws IOException {
        frame.printOnFrame("O");
    }

    @Test(expected = Exception.class)
    public void startGameMethodShouldBeRight() throws IOException {
        frame.startGame("O");
    }


}
