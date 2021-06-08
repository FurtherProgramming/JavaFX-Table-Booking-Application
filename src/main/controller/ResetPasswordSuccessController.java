package main.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.io.File;
import java.net.URL;

public class ResetPasswordSuccessController {
    @FXML private Button buttonLogin;
    public void Login(){
        goToLogin();
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();

    }
    public void goToLogin(){
        try {
            URL url = new File("src/main/ui/login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Login");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }

    }
}
