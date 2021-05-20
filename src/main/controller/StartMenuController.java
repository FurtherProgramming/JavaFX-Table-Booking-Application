package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import javafx.stage.Stage;
import java.net.URL;

public class StartMenuController {
    @FXML
    private Label labelHotdesking;
    @FXML
    Button buttonLogin;
    @FXML
    Button buttonRegister;

    public void buttonLoginOnAction(ActionEvent event){
        login();
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();

    }
    public void buttonRegisterOnAction(ActionEvent event){
        register();
        Stage stage = (Stage) buttonRegister.getScene().getWindow();
        stage.close();

    }
    public void login(){
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
    public void register() {
        try {
            URL url = new File("src/main/ui/register.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Register");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }

}
