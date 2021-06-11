package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import main.model.ManageBookingModel;
import main.model.InformationModel;
import java.time.*;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
public class ManageBookingController implements Initializable{ //delete the user's booking
    ManageBookingModel MBM = new ManageBookingModel();
    InformationModel informationModel = new InformationModel();
    @FXML private Label labelSeat;
    @FXML private Label labelDate;
    @FXML private Rectangle table1;
    @FXML private Rectangle table2;
    @FXML private Rectangle table3;
    @FXML private Rectangle table4;
    @FXML private Rectangle table5;
    @FXML private Rectangle table6;
    @FXML private Rectangle table7;
    @FXML private Rectangle table8;
    @FXML private Rectangle table9;
    @FXML private Rectangle table10;
    @FXML private Rectangle table11;
    @FXML private Rectangle table12;
    @FXML private Button buttonCancel;
    @FXML private Button buttonConfirm;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBookingDetails();
        tableUpdater(getBookingDate(), getBookingSeat());
    }
    public Date getBookingDate() {
        try {
            Date date = MBM.getUserBookingDate(informationModel.getId());
            return date;
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return null;
    }
    public int getBookingSeat(){
        try{
            int seat = MBM.getUserBookingSeat(informationModel.getId());
            return seat;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public void setBookingDetails(){
        try {
            String seatString = String.valueOf(getBookingSeat());
            //LocalDate localDate = getBookingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //String dateString = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            labelSeat.setText("Seat: " + seatString);
            //labelDate.setText("Date: " + dateString);
        } catch (Exception e) {
            e.printStackTrace();



        }
    }

    public void colourTable(int tableNumber, String colour){ // green is #1fff4e, red is #FF0000 and blue is #0400ff
        if (tableNumber == 1) {
            table1.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 2) {
            table2.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 3) {
            table3.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 4) {
            table4.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 5) {
            table5.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 6) {
            table6.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 7) {
            table7.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 8) {
            table8.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 9) {
            table9.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 10) {
            table10.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 11) {
            table11.setFill(Paint.valueOf(colour));
        }
        if (tableNumber == 12) {
            table12.setFill(Paint.valueOf(colour));
        }

    }
    public void tableUpdater(Date date, int userSeat) {
        try {

            for (int h = 1; h < 13; h++) {
                colourTable(h, "#1fff4e");
            }
            for (int i = 1; i < 13; i++) {
                if (MBM.isBooked(date, i) == true) {
                    colourTable(i, "#FF0000");
                }
            }
            colourTable(userSeat, "0400ff");

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }
    public void deleteBooking(ActionEvent event){
        MBM.deleteBooking(informationModel.getId());
        goToDeleteBooking();
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();

    }
    public void Confirm(ActionEvent event){
        goToMenu();
        Stage stage = (Stage) buttonConfirm.getScene().getWindow();
        stage.close();
    }
    public void goToMenu(){
        try {
            URL url = new File("src/main/ui/employeemenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Employee Menu");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }
    public void goToDeleteBooking(){
        try {
            URL url = new File("src/main/ui/DeleteBooking.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Booking Deleted");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }

}
