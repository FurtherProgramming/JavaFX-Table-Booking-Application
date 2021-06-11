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
import main.model.AdminViewDeskModel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class AdminViewDeskController {
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
    @FXML private DatePicker datePicker;
    @FXML private Button buttonLock;
    @FXML private Button buttonUnlock;
    @FXML private Label txtChosenTable;
    @FXML private Label labelStatus;
    AdminViewDeskModel viewModel = new AdminViewDeskModel();
    private int selectedTable;

    @FXML
    public void table1Chosen(MouseEvent event){
        tableSetup(1);

    }
    @FXML
    public void table2Chosen(MouseEvent event){
        tableSetup(2);

    }
    @FXML
    public void table3Chosen(MouseEvent event) {
        tableSetup(3);
    }
    @FXML
    public void table4Chosen(MouseEvent event) {
        tableSetup(4);

    }
    @FXML
    public void table5Chosen(MouseEvent event) {tableSetup(5);}
    @FXML
    public void table6Chosen(MouseEvent event){ tableSetup(6);;
    }
    @FXML
    public void table7Chosen(MouseEvent event){
        tableSetup(7);

    }
    @FXML
    public void table8Chosen(MouseEvent event){
        tableSetup(8);
    }
    @FXML
    public void table9Chosen(MouseEvent event){
        tableSetup(9);
    }
    @FXML
    public void table10Chosen(MouseEvent event){
        tableSetup(10);
    }
    @FXML
    public void table11Chosen(MouseEvent event){
        tableSetup(11);
    }
    @FXML
    public void table12Chosen(MouseEvent event){
        tableSetup(12);
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
    public void tableUpdater(ActionEvent event) {
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);

            for (int h = 1; h < 13; h++) {
                colourTable(h, "#1fff4e");
            }
            for (int i = 1; i < 13; i++) {
                if (viewModel.isBooked(date, i) == true) {
                    colourTable(i, "#FF0000");
                }
            }
            for (int j = 1; j < 13; j++) {
                if (viewModel.isLocked(date, j) == true)
                colourTable(j, "#ff7b00");
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }
    public void Lock(ActionEvent event){
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);
            viewModel.lockSeat(date, selectedTable);
            labelStatus.setText("Locked seat: " + selectedTable);

        } catch (Exception E) {

        }
    }
    public void Unlock(ActionEvent event){
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);
            viewModel.unlockSeat(date, selectedTable);
            labelStatus.setText("Unlocked seat: " + selectedTable);

        } catch (Exception E) {

        }
    }
    public void tableSetup(int seat){
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);
            selectedTable = seat;

            txtChosenTable.setText("Table " + seat + " ID of User: " + viewModel.getUserIDBooking(date, selectedTable));
        } catch (SQLException e) {
            e.printStackTrace();


        }

    }


}
