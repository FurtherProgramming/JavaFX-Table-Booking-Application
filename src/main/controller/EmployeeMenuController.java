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

public class EmployeeMenuController {
    @FXML
    private Button buttonBook;
    @FXML
    private Button buttonManageAcc;
    @FXML
    private Button buttonManageBook;

    public void goToBooking(ActionEvent event){ //menu for employees
        try {
            openBooking();
            Stage stage = (Stage) buttonBook.getScene().getWindow();
            stage.close();
        } catch (Exception e){

        }
    }
    public void goToManageAccount(){
        try {
            openManageAccount();
            Stage stage = (Stage) buttonManageAcc.getScene().getWindow();
            stage.close();
        } catch (Exception e){

        }
    }
    public void goToManageBooking() {
        try {
            openManageBooking();
            Stage stage = (Stage) buttonManageBook.getScene().getWindow();
            stage.close();
        } catch (Exception e){

        }

    }
    public void openBooking() {
        try {
            URL url = new File("src/main/ui/booking.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Booking");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }

    public void openManageAccount() {
        try {
            URL url = new File("src/main/ui/manageAccount.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Manage Account");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }



    public void openManageBooking() {
        try {
            URL url = new File("src/main/ui/manageBooking.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Manage Booking");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }

}
