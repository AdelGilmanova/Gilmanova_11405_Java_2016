package ru.kpfu.itis.java.Gilmanova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.java.Gilmanova.classes.Server;
import ru.kpfu.itis.java.Gilmanova.classes.Start;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Adel on 20.03.2016.
 */
@Configuration
@ComponentScan(basePackages = "ru.kpfu.itis.java.Gilmanova.classes")
public class JavaConfig {
    @Autowired
    @Qualifier("ipField")
    JTextField ipField;

    @Autowired
    @Qualifier("socket")
    Socket socket;

    @Autowired
    @Qualifier("jframe")
    JFrame jframe;

    @Autowired
    @Qualifier("bos")
    PrintWriter bos;

    @Autowired
    @Qualifier("bis")
    BufferedReader bis;

    @Autowired
    @Qualifier("jLabel")
    JLabel jLabel;


    @Bean(name = "start")
    public Start start() throws IOException {
        Start start = new Start();
        start.setSocket(socket);
        start.setIpFrame(jframe);
        start.setJframe(jframe);
        start.setBis(bis);
        start.setBos(bos);
        return start;
    }

    @Bean(name="server")
    public Server server(){
        Server server = new Server();
        server.setJframe(jframe);
        server.setText(jLabel);
        return server;
    }

    @Bean(name = "ipField")
    public JTextField ipField() {
        return new JTextField();
    }

    @Bean(name = "socket")
    public Socket socket() throws IOException {
        return new Socket(ipField.getText(), 3456);
    }

    @Bean(name = "jframe")
    public JFrame jframe() {
        return new JFrame();
    }

    @Bean(name="bos")
    public PrintWriter bos() throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    @Bean(name="bis")
    public BufferedReader bis() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Bean(name="jLabel")
    public JLabel jLabel(){
        return new JLabel("Connection...");
    }

}
