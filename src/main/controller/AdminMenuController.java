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

public class AdminMenuController {
    @FXML private Button buttonManagement;
    @FXML private Button buttonViewDesk;
    @FXML private Button buttonReleaseBooking;
    @FXML private Button buttonGenCSV;

    public void ManageAccount(ActionEvent event) { //admin menu after logging in as admin
        goToManageAccount();
        Stage stage = (Stage) buttonManagement.getScene().getWindow();
        stage.close();
    }
    public void ViewDesk(ActionEvent event) {
        goToViewDesk();
        Stage stage = (Stage) buttonViewDesk.getScene().getWindow();
        stage.close();
    }


    public void goToManageAccount(){
        try {
            URL url = new File("src/main/ui/adminManageAccount.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Employee Menu");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }
    public void goToViewDesk(){
        try {
            URL url = new File("src/main/ui/viewbooking.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("View Desk Details");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }



}
