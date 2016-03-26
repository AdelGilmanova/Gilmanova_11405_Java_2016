package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Adel on 23.12.2015.
 */
public class Client implements Runnable {
    Socket socket;
    Thread thread;
    Server server;

    public Client(Server server, Socket socket) {
        this.socket = socket;
        this.server = server;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter bos = new PrintWriter(socket.getOutputStream(), true);
            //отправляю комнаты клиенту
            bos.println(getRooms());
            while (true) {
                String action = bis.readLine();
                String[] answerPath = action.split(" ");
                if (action.equals("getRooms")) { //клиен присылает запрос на получение списка комнат
                    bos.println(getRooms());
                } else if (answerPath[0].equals("check")) {
                    String name = action.substring(6, action.length());
                    if(roomExist(name)){
                        bos.println("yes");
                    }
                    else{
                        bos.println("no");
                    }
                } else { //клиент присылает имя комнаты, в которой бы хотел играть
                    boolean check = false;
                    if (Server.players.containsKey(action)) {
                        Connection[] connections = Server.players.get(action);
                        if (connections[0] == null) {
                            bos.println("X");
                            check = true;
                        } else if (connections[1] == null) {
                            bos.println("O");
                            check = true;
                        } else {
                            bos.println("lol");
                        }
                    }
                    if (!check) {
                        bos.println("lol");
                    }
                }
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public String getRooms() {
        //нужно возвращать только свободные комнаты
        String rooms = "";
        for (Map.Entry<String, Connection[]> entry : Server.players.entrySet()) {
            if (entry.getValue()[0] == null || entry.getValue()[1] == null)
                rooms += entry.getKey() + ", ";
        }
        return rooms;
    }

    public boolean roomExist(String name){
        return Server.players.containsKey(name);
    }
}
