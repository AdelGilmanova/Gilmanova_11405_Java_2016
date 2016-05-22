package ru.kpfu.itis.Gilmanova.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.Gilmanova.client.FXMLDialog;
import ru.kpfu.itis.Gilmanova.model.Comment;
import ru.kpfu.itis.Gilmanova.service.CommentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adel on 18.05.2016.
 */

public class MainController implements DialogController {
    private FXMLDialog dialog;

    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @FXML
    StackPane view;
    @FXML
    public HBox taskbar;
    @Autowired
    private CommentModel model;
    ObservableList<Comment> data;

    @FXML
    public void comments(ActionEvent actionEvent) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        Text scenetitle = new Text("Комментарии");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);

        List<Comment> comments = model.getComments();
        data = FXCollections.observableArrayList(comments);
        ListView listView = new ListView();
        listView.setPrefWidth(1000);
        listView.setItems(data);
        grid.add(listView, 0, 1, 3, 1);

        final TextField name = new TextField();
        name.setPromptText("Ваше имя");
        name.setPrefWidth(90);
        grid.add(name, 0, 2);

        final TextField comment = new TextField();
        comment.setPromptText("Комментарий");
        comment.setPrefWidth(280);
        grid.add(comment, 1, 2);

        Button btn = new Button("Добавить");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Comment commentEntity = model.addComment(name.getText(), comment.getText());
                name.setText("");
                comment.setText("");
                data.add(commentEntity);
            }
        });
        grid.add(btn, 2, 2);
        changeView(grid);
    }

    @FXML
    public void news(ActionEvent actionEvent) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        Text scenetitle = new Text("Новости гимназии");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);

        List<String> news = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            news.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n" +
                    "Integer leo purus, pharetra vitae neque ut, cursus elementum turpis. \n" +
                    "Suspendisse et lorem quis erat iaculis maximus vitae non justo. \n");
        }
        ObservableList<String> data = FXCollections.observableArrayList(news);
        ListView listView = new ListView();
        listView.setPrefWidth(1000);
        listView.setItems(data);
        grid.add(listView, 0, 1);

        changeView(grid);
    }

    @FXML
    public void cancel() {
        dialog.close();
    }

    private void changeView(Node node) {
        view.getChildren().clear();
        view.getChildren().add(node);
    }
}
