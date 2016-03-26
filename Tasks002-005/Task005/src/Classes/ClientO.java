package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adel on 28.10.2015.
 */
//�����, �������� ��������
public class ClientO implements Runnable {
    OFrame frame;
    Thread thread;

    public ClientO(OFrame frame) throws IOException {
        this.frame = frame;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(frame.getSocket().getInputStream()));
            String answer = bis.readLine(); //��������� ����� �������
            frame.startGame(answer);
            while (true) {
                answer = bis.readLine(); //��������� ����� �������
                if (answer.equals("end")) {
                    System.exit(-1);
                } else frame.printOnFrame(answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

