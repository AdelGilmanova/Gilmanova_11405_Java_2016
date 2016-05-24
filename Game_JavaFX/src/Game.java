import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Adel on 23.05.2016.
 */
public class Game extends Application {
    AnimationTimer timer;
    Timeline timeline;
    int xStart = (int) (Math.random() * 600 + 100);
    int yStart = (int) (Math.random() * 600 + 100);
    private Integer i = 0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Catch me, if you try");
        Group group = new Group();
        Scene scene = new Scene(group, 700, 700, Color.WHITE);

        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        addBall(scene, stage);
        stage.show();
    }

    private void addBall(Scene scene, Stage stage) {
        final Group group = (Group) scene.getRoot();
        Text time = getTime(group);
        Button button = getButton(stage, group);
        Circle circle = getCircle(group, time, stage, button);
        Path path = getPath(group, circle);
        PathTransition pathTransition = getPathTransition(path, circle);
        createTimeline(circle);
        createTimer(time);

        pathTransition.play();
        timeline.play();
        timer.start();
    }

    private Circle getCircle(Group group, Text time, Stage stage, Button btn) {
        Circle circle = new Circle(xStart, yStart, 25);
        circle.setFill(Color.DARKRED);
        circle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    group.getChildren().remove(circle);
                    timer.stop();
                    checkResult(time.getText());
                    Text result = new Text("Ваш результат: " + time.getText());
                    result.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    result.setLayoutX(250);
                    result.setLayoutY(300);
                    group.getChildren().add(result);

                    Text record = new Text("Лучший результат: " + getRecord());
                    record.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    record.setLayoutX(250);
                    record.setLayoutY(330);
                    group.getChildren().add(record);

                    Button button = new Button("Выйти");
                    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.close();
                        }
                    });
                    button.setLayoutX(320);
                    button.setLayoutY(360);
                    group.getChildren().add(button);

                    group.getChildren().remove(btn);
                    group.getChildren().remove(time);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return circle;
    }

    private Text getTime(Group group) {
        Text time = new Text();
        time.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        time.setLayoutX(60);
        time.setLayoutY(20);
        group.getChildren().add(time);
        return time;
    }

    private Button getButton(Stage stage, Group group) {
        Button button = new Button("X");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
            }
        });
        group.getChildren().add(button);
        return button;
    }

    private Path getPath(Group group, Circle circle) {
        Path path = new Path();
        path.getElements().add(new MoveTo(xStart, yStart));
        for (int i = 0; i < 6; i++) {
            int x1 = (int) (Math.random() * 600 + 100);
            int y1 = (int) (Math.random() * 600 + 100);
            int x2 = (int) (Math.random() * 600 + 100);
            int y2 = (int) (Math.random() * 600 + 100);
            int x = (int) (Math.random() * 600 + 100);
            int y = (int) (Math.random() * 600 + 100);
            path.getElements().add(new CubicCurveTo(x1, y1, x2, y2, x, y));
        }
        path.setOpacity(0.0);
        group.getChildren().add(path);
        group.getChildren().add(circle);
        return path;
    }

    private PathTransition getPathTransition(Path path, Circle circle) {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(4.0));
        pathTransition.setDelay(Duration.seconds(.5));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        return pathTransition;
    }

    private void createTimeline(Circle circle) {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue keyValueX = new KeyValue(circle.scaleXProperty(), 1.8);
        KeyValue keyValueY = new KeyValue(circle.scaleYProperty(), 1.8);

        Duration duration = Duration.millis(2000);
        KeyFrame keyFrame = new KeyFrame(duration, keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);
    }

    private void createTimer(Text time) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                time.setText(i.toString());
                i++;
            }
        };
    }

    private void writeResult(String result) throws IOException {
        try (FileOutputStream fin = new FileOutputStream("file.txt");
             PrintWriter pw = new PrintWriter(fin)) {
            pw.write(result);
        }
    }

    private int getRecord() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        return scanner.nextInt();
    }

    private void checkResult(String value) throws IOException {
        int result = Integer.parseInt(value);
        int record = getRecord();
        String string = String.valueOf(Math.min(record, result));
        writeResult(string);
    }
    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
}
