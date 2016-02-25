package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Adel on 28.10.2015.
 */
//�����, �������� ��������
public class OFrame extends JFrame {
    private Socket socket;
    PrintWriter bos;

    private JFrame jframe = new JFrame("Gomoku");
    private JPanel panel = new JPanel();
    private JFrame waiting = new JFrame();
    private int size;
    private int buttonSize = 50;
    private JButton[][] buttons;
    private int closeFieldCount;
    public String clientName;

    public OFrame(String ip, int size, String clientName) throws IOException {
        socket = new Socket(ip, 3456);
        bos = new PrintWriter(socket.getOutputStream(), true);

        //��������� ���� � �������
        bos.println("second");
        this.clientName = clientName;
        if (clientName == null) bos.println("O");
        else bos.println("O" + clientName);

        this.size = size;
        buttons = new JButton[size][size];
        closeFieldCount = size * size;
        panel.setBackground(Color.DARK_GRAY);
        jframe.add(panel);
        panel.setLayout(new GridLayout(size, size));
        createButtons();

        jframe.setBounds(400, 0, buttonSize * size + 15, buttonSize * size + 39);
        //jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(false);
        jframe.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                bos.println("end");
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

        JLabel msg = new JLabel("��������...");
        waiting.add(msg);
        waiting.setVisible(true);
        waiting.setBounds(500, 100, 400, 300);
        waiting.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                bos.println("end");
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
    }

    public void createButtons() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton jb = new JButton();
                jb.setBackground(Color.DARK_GRAY);
                jb.setForeground(Color.GRAY);
                jb.setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jb1 = (JButton) e.getSource();
                        int x = (jb1.getX() + (buttonSize / 2)) / buttonSize;
                        int y = (jb1.getY() + (buttonSize / 2)) / buttonSize;
                        bos.println("O, " + x + ", " + y); //�� ������ ������������ ���������� ������� ������ o
                        if (jb1.isEnabled()) {
                            jb1.setText("O");
                            buttons[y][x] = jb1;
                            jb1.setEnabled(false);
                            if (checkField(y, x, "O")) {
                                showFrame(true);
                            } else {
                                closeFieldCount--;
                                jframe.setEnabled(false);
                                if (closeFieldCount == 0) drawFrame();
                            }
                        }
                    }
                });
                buttons[i][j] = jb;
                panel.add(jb);
            }
        }
    }

    public void showFrame(boolean param) {
        String win = "You win";
        String lose = "You lose";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
        if (param) {
            JOptionPane.showMessageDialog(jframe, win);
        } else {
            JOptionPane.showMessageDialog(jframe, lose);
        }
    }

    public void drawFrame() {
        JOptionPane.showMessageDialog(jframe, "Game over");
    }

    public boolean checkField(int x, int y, String sign) {
        for (int i = 1; i <= 4; i++) {
            int count = 0;
            for (int j = -1; j > -5; j--) {
                //x=y
                if (i == 1 && x + j >= 0 && x + j < size && y + j >= 0 && y + j < size) {
                    if (buttons[x + j][y + j].getText().equals(sign)) ++count;
                    else break;
                }
                //y=0
                if (i == 2 && x + j >= 0 && x + j < size) {
                    if (buttons[x + j][y].getText().equals(sign)) ++count;
                    else break;
                }
                //x=-y
                if (i == 3 && x - j >= 0 && x - j < size && y + j >= 0 && y + j < size) {
                    if (buttons[x - j][y + j].getText().equals(sign)) ++count;
                    else break;
                }
                //x=0
                if (i == 4 && y + j >= 0 && y + j < size) {
                    if (buttons[x][y + j].getText().equals(sign)) ++count;
                    else break;
                }
            }
            for (int j = 1; j < 5; j++) {
                //x=y
                if (i == 1 && x + j >= 0 && x + j < size && y + j >= 0 && y + j < size) {
                    if (buttons[x + j][y + j].getText().equals(sign)) ++count;
                    else break;
                }
                //y=0
                if (i == 2 && x + j >= 0 && x + j < size) {
                    if (buttons[x + j][y].getText().equals(sign)) ++count;
                    else break;
                }
                //x=-y
                if (i == 3 && x - j >= 0 && x - j < size && y + j >= 0 && y + j < size) {
                    if (buttons[x - j][y + j].getText().equals(sign)) ++count;
                    else break;
                }
                //x=0
                if (i == 4 && y + j >= 0 && y + j < size) {
                    if (buttons[x][y + j].getText().equals(sign)) ++count;
                    else break;
                }
            }
            if (count >= 4) return true;
        }
        return false;
    }

    public void printOnFrame(String answer) throws IOException {
        String[] str = answer.split(", ");
        String sign = str[0];
        int x = Integer.parseInt(str[1]);
        int y = Integer.parseInt(str[2]);
        JButton jb = buttons[y][x];
        if (jb.isEnabled()) {
            if (sign.equals("X")) jb.setText("X");
            else jb.setText("O");
            jb.setEnabled(false);
            closeFieldCount--;
            if (closeFieldCount == 0) drawFrame();
            buttons[y][x] = jb;
            jframe.setEnabled(true);
        }
        if (sign.equals("X")) {
            unblockFrame();
            if (checkField(y, x, "X")) showFrame(false);
        }

    }

    public void startGame(String answer) {
        waiting.dispose();
        jframe.setEnabled(false);
        jframe.setVisible(true);
    }


    public void unblockFrame() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (buttons[i][j].getText().isEmpty())
                    buttons[i][j].setEnabled(true);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}