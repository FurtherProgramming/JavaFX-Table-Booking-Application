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
import main.model.InformationModel;


public class RegistrationSuccessfulController {
    @FXML
    Button buttonLogin;
    InformationModel informationModel = new InformationModel();

    public void backToStartMenu(ActionEvent event){
        if (informationModel.getRole().equals("employee")) {
            StartMenu();
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.close();
        }
        if (informationModel.getRole().equals("admin")) {
            AdminMenu();
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.close();
        }
    }



    public void StartMenu(){
        try {
            URL url = new File("src/main/ui/startmenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Welcome to HotDesking");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }
    public void AdminMenu(){
            try {
                URL url = new File("src/main/ui/adminmenu.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Stage viewStage = new Stage();
                Scene scene = new Scene(root);
                viewStage.setTitle("Admin Menu");
                viewStage.setScene(scene);
                viewStage.show();
            } catch(Exception e) {

            }
    }
}

