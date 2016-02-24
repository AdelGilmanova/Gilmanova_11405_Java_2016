package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Adel on 20.12.2015.
 */
public class Start {
    Socket socket;
    PrintWriter bos;
    BufferedReader bis;
    public ArrayList<XFrame> xFrames = new ArrayList<>();
    public ArrayList<OFrame> oFrames = new ArrayList<>();
    final JFrame jframe = new JFrame("Gomoku");
    public JFrame ipFrame = new JFrame();

    public void start() {
        ipFrame.dispose();
        jframe.setVisible(true);
    }

    public Start() throws IOException {
        JLabel jLabel1 = new JLabel("������� IP");
        final JTextField ipField = new JTextField();
        JButton insertIP = new JButton("OK");
        ipFrame.add(ipField);
        ipFrame.add(insertIP);
        ipFrame.add(jLabel1);
        GroupLayout layout = new GroupLayout(ipFrame.getContentPane());
        ipFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ipField, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(insertIP)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(insertIP))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        insertIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ipField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(jframe,
                                "����� ������ IP");
                    } else {
                        socket = new Socket(ipField.getText(), 3456);
                        bos = new PrintWriter(socket.getOutputStream(), true);
                        bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        createStartFrame(ipField.getText());
                        start();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        ipFrame.setBounds(500, 100, 350, 180);
        ipFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ipFrame.setVisible(true);
    }

    public void createStartFrame(final String ip) throws IOException {
        //���� ������� ������, ��� ��� ������� �����
        bos.println("first");
        //�������� �� ������� ������ ��������� ������
        String players = bis.readLine();
        String[] rooms = players.split(", ");

        JButton refresh = new JButton("��������");
        JButton jbX = new JButton("�");
        JButton jbO = new JButton("�");
        final JTextField textField = new JTextField();
        JLabel room = new JLabel("������ ��������� ������:");
        JButton joinRoom = new JButton("������");
        JLabel name = new JLabel("������� ���� ��� � �������� � ��� �, ����� ������ ����� ����.");

        final DefaultListModel listModel = new DefaultListModel();
        for (String roomm : rooms) {
            listModel.addElement(roomm);
        }
        final JList list = new JList(listModel);
        list.setFocusable(true);
        list.setSelectedIndex(0);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(list);
        jframe.add(scrollPane);

        GroupLayout layout = new GroupLayout(jframe.getContentPane());
        jframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(name)
                                                .addGap(0, 82, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(room)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                                                .addComponent(joinRoom)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(refresh, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(textField)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jbX)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbO)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(room)
                                        .addComponent(joinRoom)
                                        .addComponent(refresh))
                                .addGap(13, 13, 13)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbO)
                                        .addComponent(jbX)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        jbX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(jframe,
                                "������ ���� ���");
                    } else {
                        //�������� ���� �� ����� ���, ���� ����, �� �������� ���������
                        bos.println("check " + textField.getText());
                        String roomExisting = bis.readLine();
                        if (roomExisting.equals("yes")) {
                            JOptionPane.showMessageDialog(jframe,
                                    "����� ��� ��� ����������. ������� ������.");
                            textField.setText("");
                        } else {
                            XFrame xFrame = new XFrame(ip, 10, textField.getText());
                            new ClientX(xFrame);
                            xFrames.add(xFrame);
                            //.dispose();
                        }
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jbO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(jframe,
                                "������ ���� ���");
                    } else {
                        //�������� ���� �� ����� ���, ���� ����, �� �������� ���������
                        bos.println("check " + textField.getText());
                        String roomExisting = bis.readLine();
                        if (roomExisting.equals("yes")) {
                            JOptionPane.showMessageDialog(jframe,
                                    "����� ��� ��� ����������. ������� ������.");
                            textField.setText("");
                        } else {
                            OFrame oFrame = new OFrame(ip, 10, textField.getText());
                            new ClientO(oFrame);
                            oFrames.add(oFrame);
                            //jframe.dispose();
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        joinRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = (String) listModel.getElementAt(list.getSelectedIndex());
                    bos.println(name);
                    //������� ����� �� ������� �� ��������� ���� �����, ����� ���� �������
                    String answer = bis.readLine();
                    if (answer.equals("X")) {
                        XFrame xFrame = new XFrame(ip, 10, name);
                        xFrames.add(xFrame);
                        new ClientX(xFrame);
                        //jframe.dispose();
                    }
                    if (answer.equals("O")) {
                        OFrame oFrame = new OFrame(ip, 10, name);
                        oFrames.add(oFrame);
                        new ClientO(oFrame);
                        //jframe.dispose();
                    }
                    if (answer.equals("lol")) {
                        JOptionPane.showMessageDialog(jframe,
                                "�� �� ������ ������ ���� � ���� �������. �������� ������.");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bos.println("getRooms");
                    //�������� �� ������� ������ ��������� ������
                    String players = bis.readLine();
                    String[] rooms = players.split(", ");
                    listModel.removeAllElements();
                    for (String room : rooms) {
                        listModel.addElement(room);
                    }
                    //final JList list = new JList(listModel);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jframe.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                for (XFrame frame : xFrames) {
                    frame.bos.println("end");
                }
                for (OFrame frame : oFrames) {
                    frame.bos.println("end");
                }
                System.exit(-1);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        jframe.add(room);
        jframe.add(refresh);
        jframe.add(joinRoom);
        jframe.add(name);
        jframe.add(textField);
        jframe.add(jbX);
        jframe.add(jbO);
        jframe.setBounds(100, 100, 500, 300);
        jframe.setVisible(false);
    }

    public static void main(String[] args) throws IOException {
        new Start();
    }
}
