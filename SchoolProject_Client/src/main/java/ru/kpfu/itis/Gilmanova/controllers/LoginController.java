package ru.kpfu.itis.Gilmanova.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.Gilmanova.client.FXMLDialog;
import ru.kpfu.itis.Gilmanova.client.ScreensConfiguration;

/**
 * Created by Adel on 18.05.2016.
 */

public class LoginController implements DialogController {
    @Autowired
    private AuthenticationManager authenticationManager;
    private ScreensConfiguration screens;
    private FXMLDialog dialog;

    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    public LoginController(ScreensConfiguration screens) {
        this.screens = screens;
    }

    @FXML
    GridPane gridPane;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    public void login() {
        Authentication authToken = new UsernamePasswordAuthenticationToken(username.getText(), password.getText());
        try {
            authToken = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authToken);
        } catch (AuthenticationException e) {
            final Text actiontarget = new Text();
            gridPane.add(actiontarget, 0, 11);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setId("actiontarget");
            actiontarget.setText("Не удалось войти, попробуйте снова");
            return;
        }
        dialog.close();
        //screens.showScreen(screens.commentDataScreen());
        screens.addMenu().show();
    }

}
