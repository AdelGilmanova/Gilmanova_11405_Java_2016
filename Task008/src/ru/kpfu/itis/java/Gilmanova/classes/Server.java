package ru.kpfu.itis.java.Gilmanova.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.java.Gilmanova.JavaConfig;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adel on 09.11.2015.
 */
public class Server implements Serializable {
    final static int PORT = 3456;
    public static volatile Map<String, Connection[]> players = new HashMap<>();

    @Autowired
    @Qualifier("jframe")
    public JFrame jframe;

    @Autowired
    @Qualifier("jLabel")
    JLabel text;

    public Server() {}

    public void start() throws IOException {
        jframe.setTitle("Server");
        jframe.setBounds(100, 0, 200, 100);
        jframe.add(text);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        go();
    }

    public void go() throws IOException {
        Connection[] array;
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            System.out.println("Connection..");
            Socket client = s1.accept();
            BufferedReader bis = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter bos = new PrintWriter(client.getOutputStream(), true);
            //тут ждать пока придет инфа о клиенте и потом выбрать что с ним делать
            String action = bis.readLine();
            if (action.equals("first")) {
                //System.out.println("first");
                //создаю нового клиента, он еще не играет
                new Client(this, client);
            } else if (action.equals("second")) {
                //System.out.println("second");
                String clientAnswer = bis.readLine();
                //System.out.println(clientAnswer);//например Xadel
                boolean check = false;
                if (players.containsKey(clientAnswer.substring(1, clientAnswer.length()))) {//если такая комната есть
                    Connection[] connections = Server.players.get(clientAnswer.substring(1, clientAnswer.length()));
                    if (clientAnswer.charAt(0) == 'X') {
                        connections[0] = new Connection(this, client, clientAnswer.substring(1, clientAnswer.length()));
                        players.put(clientAnswer.substring(1, clientAnswer.length()), connections);
                    } else if (clientAnswer.charAt(0) == 'O') {
                        connections[1] = new Connection(this, client, clientAnswer.substring(1, clientAnswer.length()));
                        players.put(clientAnswer.substring(1, clientAnswer.length()), connections);
                    }
                    check = true;
                }
                if (!check) {//если комнаты уже нет или она занята, создает новую
                    if (clientAnswer.charAt(0) == 'X') {
                        array = new Connection[2];
                        array[0] = new Connection(this, client, clientAnswer.substring(1, clientAnswer.length()));
                        players.put(clientAnswer.substring(1, clientAnswer.length()), array);
                    } else if (clientAnswer.charAt(0) == 'O') {
                        array = new Connection[2];
                        array[1] = new Connection(this, client, clientAnswer.substring(1, clientAnswer.length()));
                        players.put(clientAnswer.substring(1, clientAnswer.length()), array);
                    }
                }
                String s = "";
                for (Map.Entry<String, Connection[]> entry : Server.players.entrySet()) {
                    s += entry.getKey() + ": " + entry.getValue()[0] + ", " + entry.getValue()[1];
                }
                System.out.println(s);

            }
        }
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public static void deleteRoom(String room) {
        if (players.containsKey(room)) {
            System.out.println("Delete room: " + room);
            players.remove(room);
        }
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        Server server = ac.getBean(Server.class);
        server.start();
    }

}
