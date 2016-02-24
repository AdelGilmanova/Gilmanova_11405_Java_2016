package Tests;

import Classes.Connection;
import Classes.Server;
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
public class Connection_Test {
    private static Connection connection;
    private static Socket socket;
    private static Server server;

    @BeforeClass
    public static void createClientO() throws IOException {
        InputStream is = mock(InputStream.class);
        socket = mock(Socket.class);
        server = mock(Server.class);
        when(socket.getInputStream()).thenReturn(is);
        connection = new Connection(server, socket, "roomName");
    }

    @Test(expected = IOException.class)
    public void runMethodShouldCatchException() {
        connection.run();
    }
}
