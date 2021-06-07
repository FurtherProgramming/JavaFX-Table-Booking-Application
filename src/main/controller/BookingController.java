package main.controller;

import java.time.LocalDate;
import javafx.fxml.FXML;
import java.sql.Date;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.DatePicker;
import main.model.BookingModel;
import java.awt.Color;
import main.SQLConnection;


import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookingController {
    BookingModel bookingModel = new BookingModel();
    @FXML
    private Rectangle table1;
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
    @FXML private Button buttonT1;
    @FXML private Button buttonT2;
    @FXML private Button buttonT3;
    @FXML private Button buttonT4;
    @FXML private Button buttonT5;
    @FXML private Button buttonT6;
    @FXML private Button buttonT7;
    @FXML private Button buttonT8;
    @FXML private Button buttonT9;
    @FXML private Button buttonT10;
    @FXML private Button buttonT11;
    @FXML private Button buttonT12;
    @FXML private DatePicker datePicker;
    @FXML private Button buttonTables;
    @FXML private Button buttonConfirm;
    @FXML private TextField txtID;


    private int selectedTable;
    public void table1Booking(ActionEvent event){
        selectedTable = 1;
    }
    public void table2Booking(ActionEvent event){
        selectedTable = 2;
    }
    public void table3Booking(ActionEvent event){
        selectedTable = 3;
    }
    public void table4Booking(ActionEvent event){
        selectedTable = 4;
    }
    public void table5Booking(ActionEvent event){
        selectedTable = 5;
    }
    public void table6Booking(ActionEvent event){
        selectedTable = 6;
    }
    public void table7Booking(ActionEvent event){
        selectedTable = 7;
    }
    public void table8Booking(ActionEvent event){
        selectedTable = 8;
    }
    public void table9Booking(ActionEvent event){
        selectedTable = 9;
    }
    public void table10Booking(ActionEvent event){
        selectedTable = 10;
    }
    public void table11Booking(ActionEvent event){
        selectedTable = 11;
    }
    public void table12Booking(ActionEvent event){
        selectedTable = 12;
    }
    public void makeBooking(ActionEvent event){
        try {
        LocalDate localDate = datePicker.getValue();
        Date date = Date.valueOf(localDate);
        if (bookingModel.isBooked(date, selectedTable) == false){
            bookingModel.book(Integer.parseInt(txtID.getText()), date, selectedTable);

        }

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public void tableUpdater(ActionEvent event) {
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);
            for (int i = 1; i < 13; i++){
                if (bookingModel.isBooked(date, i) == true);
                redTable(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
    public void redTable(int tableNumber) {
        if (tableNumber == 1) {
            table1.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 2) {
            table2.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 3) {
            table1.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 4) {
            table4.setFill(Paint.valueOf("FF0000"));
        }
        if (tableNumber == 5) {
            table5.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 6) {
            table6.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 7) {
            table7.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 8) {
            table8.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 9) {
            table9.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 10) {
            table10.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 11) {
            table11.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 12) {
            table12.setFill(Paint.valueOf("#FF0000"));
        }
    }


}
