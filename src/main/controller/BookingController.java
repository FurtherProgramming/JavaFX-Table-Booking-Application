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
    private Rectangle table2;
    private Rectangle table3;
    private Rectangle table4;
    private Rectangle table5;
    private Rectangle table6;
    private Rectangle table7;
    private Rectangle table8;
    private Rectangle table9;
    private Rectangle table10;
    private Rectangle table11;
    private Rectangle table12;
    private Button buttonT1;
    private Button buttonT2;
    private Button buttonT3;
    private Button buttonT4;
    private Button buttonT5;
    private Button buttonT6;
    private Button buttonT7;
    private Button buttonT8;
    private Button buttonT9;
    private Button buttonT10;
    private Button buttonT11;
    private Button buttonT12;
    private DatePicker datePicker;
    private Button buttonTables;
    private Button buttonConfirm;

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
            table6.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 10) {
            table6.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 11) {
            table6.setFill(Paint.valueOf("#FF0000"));
        }
        if (tableNumber == 12) {
            table6.setFill(Paint.valueOf("#FF0000"));
        }
    }


}
