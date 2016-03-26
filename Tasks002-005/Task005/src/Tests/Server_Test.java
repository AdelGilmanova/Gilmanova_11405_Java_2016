package Tests;

import Classes.Server;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Adel on 23.02.2016.
 */
public class Server_Test {
    private static Server server;

    @BeforeClass
    public static void createServer() throws IOException {
        server = new Server();
    }

    @Test(expected = IOException.class)
    public void goMethodShouldBeRight() throws IOException {
        server.go();
    }

    @Test(expected = IOException.class)
    public void deleteRoomMethodShouldBeRight() throws IOException {
        Server.deleteRoom("room");
    }

    @Test(expected = IOException.class)
    public void mainMethodShouldBeRight() throws IOException {
        Server.main(null);
    }
}
