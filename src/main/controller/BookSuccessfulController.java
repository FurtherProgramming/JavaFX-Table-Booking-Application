package main.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.net.URL;



public class BookSuccessfulController {
    @FXML Button buttonMenu;
    public void goToMenu(){
        menu();
        Stage stage = (Stage) buttonMenu.getScene().getWindow();
        stage.close();

    }

    public void menu(){
        try {
            URL url = new File("src/main/ui/employeemenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Registration Successful");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }

}
