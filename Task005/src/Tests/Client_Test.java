package Tests;

import Classes.Client;
import Classes.Server;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class Client_Test {
    private static Client client;
    private static Socket socket;
    private static Server server;

    @BeforeClass
    public static void createCleint() throws IOException {
        socket = mock(Socket.class);
        InputStream is = mock(InputStream.class);
        OutputStream os = mock(OutputStream.class);
        when(socket.getInputStream()).thenReturn(is);
        when(socket.getOutputStream()).thenReturn(os);
        server = mock(Server.class);
        client = new Client(server, socket);
    }



    @Test(expected = IOException.class)
    public void runMethodShouldCatchException() {
        client.run();
    }

    @Test
    public void getRoomMethodShouldBeRight() {
        Assert.assertEquals("", client.getRooms());
    }

    @Test
    public void roomExistMethodShouldBeRight(){
        Assert.assertEquals(false, client.roomExist(""));
    }

}
