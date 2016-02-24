package Tests;

import Classes.ClientX;
import Classes.XFrame;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class ClientX_Test {
    private static ClientX client;
    private static XFrame frame;;
    private static Socket socket;

    @BeforeClass
    public static void createClientO() throws IOException {
        InputStream is = mock(InputStream.class);
        socket = mock(Socket.class);
        frame = mock(XFrame.class);
        when(frame.getSocket()).thenReturn(socket);
        when(socket.getInputStream()).thenReturn(is);
        client = new ClientX(frame);
    }

    @Test(expected = IOException.class)
    public void runMethodShouldCatchException() {
        client.run();
    }
}
