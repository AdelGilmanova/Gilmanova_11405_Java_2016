package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Adel on 09.11.2015.
 */
public class Connection implements Runnable {
    Socket socket;
    Thread thread;
    Server server;
    String roomName;

    public Connection(Server server, Socket socket, String roomName) {
        this.socket = socket;
        this.server = server;
        this.roomName = roomName;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //сказать клиенту, что игра началась
            for (Map.Entry<String, Connection[]> entry : Server.players.entrySet()) {
                if ((entry.getValue()[0] == this && entry.getValue()[1] != null) ||
                        (entry.getValue()[1] == this && entry.getValue()[0] != null)) {
                    for (Connection con : entry.getValue()) {
                        PrintWriter bos = new PrintWriter(con.socket.getOutputStream(), true);
                        bos.println("start");
                    }
                    break;
                }
            }

            while (true) {
                String clientAnswer = bis.readLine(); //считывет ответ клиента
                if (clientAnswer.equals("end")) {
                    //удаление комнаты
                    if (Server.players.containsKey(roomName)) {
                        Connection[] con = Server.players.get(roomName);
                        if (con[0] != null) {
                            PrintWriter bos = new PrintWriter(con[0].socket.getOutputStream(), true);
                            bos.println("end");
                        }
                        if (con[1] != null) {
                            PrintWriter bos = new PrintWriter(con[1].socket.getOutputStream(), true);
                            bos.println("end");
                        }
                        Server.deleteRoom(roomName);
                    }
                } else {
                    if (Server.players.containsKey(roomName)) {
                        Connection[] con = Server.players.get(roomName);
                        PrintWriter bos = new PrintWriter(con[0].socket.getOutputStream(), true);
                        bos.println(clientAnswer);
                        bos = new PrintWriter(con[1].socket.getOutputStream(), true);
                        bos.println(clientAnswer);
                    }
                }
            }

        } catch (IOException e) {
            //e.printStackTrace();
            try {
                if (Server.players.containsKey(roomName)) {
                    Connection[] con = Server.players.get(roomName);
                    if (con[0] != null) {
                        PrintWriter bos = new PrintWriter(con[0].socket.getOutputStream(), true);
                        bos.println("end");
                    }
                    if (con[1] != null) {
                        PrintWriter bos = new PrintWriter(con[1].socket.getOutputStream(), true);
                        bos.println("end");
                    }
                    Server.deleteRoom(roomName);
                }
            } catch (IOException e1) {
            }
            Server.deleteRoom(roomName);
        }
    }
}
