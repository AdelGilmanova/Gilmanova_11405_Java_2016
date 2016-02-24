package Tests;

import Classes.ClientO;
import Classes.OFrame;
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
public class ClientO_Test {
    private static ClientO client;
    private static OFrame frame;;
    private static Socket socket;

    @BeforeClass
    public static void createClientO() throws IOException {
        InputStream is = mock(InputStream.class);
        socket = mock(Socket.class);
        frame = mock(OFrame.class);
        when(frame.getSocket()).thenReturn(socket);
        when(socket.getInputStream()).thenReturn(is);
        client = new ClientO(frame);
    }

    @Test(expected = IOException.class)
    public void runMethodShouldCatchException() {
        client.run();
    }
}
