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

public class AdminManageAccountController {
    @FXML private Button buttonAddAcc;
    @FXML private Button buttonDeleteAcc;
    @FXML private Button buttonUpdateAcc;

    public void AddAccount(){
        goToAddAccount();
        Stage stage = (Stage) buttonAddAcc.getScene().getWindow();
        stage.close();
    }
    public void DeleteAccount(){
        goToDeleteAccount();
        Stage stage = (Stage) buttonDeleteAcc.getScene().getWindow();
        stage.close();
    }
    public void UpdateAccount(){
        goToUpdateAccount();
        Stage stage = (Stage) buttonUpdateAcc.getScene().getWindow();
        stage.close();
    }
    public void goToAddAccount() {
        try {
            URL url = new File("src/main/ui/addaccount.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Add Account");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }
    public void goToDeleteAccount() {
        try {
            URL url = new File("src/main/ui/admindeleteaccount.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Delete Account");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }
    public void goToUpdateAccount() {
        try {
            URL url = new File("src/main/ui/adminupdateaccount.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Update Account");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }
}
