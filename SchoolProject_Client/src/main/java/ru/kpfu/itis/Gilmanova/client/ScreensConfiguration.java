package ru.kpfu.itis.Gilmanova.client;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.kpfu.itis.Gilmanova.controllers.*;

/**
 * Created by Adel on 18.05.2016.
 */

@Configuration
@Lazy
public class ScreensConfiguration {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
        primaryStage.setScene(new Scene(screen, 777, 500));
        primaryStage.show();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog loginDialog() {
        return new FXMLDialog(loginController(), getClass().getResource("Login.fxml"), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog addMenu() {
        return new FXMLDialog(addMainController(), getClass().getResource("main.fxml"), primaryStage);
    }

    @Bean
    @Scope("prototype")
    MainController addMainController() {
        return new MainController();
    }

    @Bean
    @Scope("prototype")
    LoginController loginController() {
        return new LoginController(this);
    }
}
