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
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


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
    @FXML private DatePicker datePicker;
    @FXML private Button buttonTables;
    @FXML private Button buttonConfirm;
    @FXML private TextField txtID;
    @FXML private Label txtChosenTable;
    @FXML private Label labelStatus;


    private int selectedTable;






    @FXML
    public void table1Booking(MouseEvent event){
        selectedTable = 1;
        txtChosenTable.setText("Table 1");
    }
    @FXML
    public void table2Booking(MouseEvent event){
        selectedTable = 2;txtChosenTable.setText("Table 2");
    }
    @FXML
    public void table3Booking(MouseEvent event) { selectedTable = 3; txtChosenTable.setText("Table 3");}
    @FXML
    public void table4Booking(MouseEvent event) { selectedTable = 4; txtChosenTable.setText("Table 4");}
    @FXML
    public void table5Booking(MouseEvent event) { selectedTable = 5; txtChosenTable.setText("Table 5");}
    @FXML
    public void table6Booking(MouseEvent event){  selectedTable = 6; txtChosenTable.setText("Table 6");
    }
    @FXML
    public void table7Booking(MouseEvent event){
        selectedTable = 7; txtChosenTable.setText("Table 7");
    }
    @FXML
    public void table8Booking(MouseEvent event){
        selectedTable = 8; txtChosenTable.setText("Table 8");
    }
    @FXML
    public void table9Booking(MouseEvent event){
        selectedTable = 9; txtChosenTable.setText("Table 9");
    }
    @FXML
    public void table10Booking(MouseEvent event){
        selectedTable = 10;txtChosenTable.setText("Table 10");
    }
    @FXML
    public void table11Booking(MouseEvent event){
        selectedTable = 11;txtChosenTable.setText("Table 11");
    }
    @FXML
    public void table12Booking(MouseEvent event){
        selectedTable = 12;txtChosenTable.setText("Table 12");
    }
    public void makeBooking(ActionEvent event){
        try {
        LocalDate localDate = datePicker.getValue();
        Date date = Date.valueOf(localDate);
        if (bookingModel.isBooked(date, selectedTable) == false) {
            bookingModel.book(Integer.parseInt(txtID.getText()), date, selectedTable);
            bookingSuccessful();
            Stage stage = (Stage) buttonConfirm.getScene().getWindow();
            stage.close();


        }
        if (bookingModel.isBooked(date, selectedTable) == true) {
            labelStatus.setText("Table has been booked");
        }

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public void tableUpdater(ActionEvent event) {
        try {
            LocalDate localDate = datePicker.getValue();
            Date date = Date.valueOf(localDate);
            for (int h = 1; h < 13; h++){
                greenTable(h);
            }
            for (int i = 1; i < 13; i++){
                if (bookingModel.isBooked(date, i) == true) {
                    redTable(i);
                }
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
            table3.setFill(Paint.valueOf("#FF0000"));
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
    public void greenTable(int tableNumber) {
        if (tableNumber == 1) {
            table1.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 2) {
            table2.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 3) {
            table3.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 4) {
            table4.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 5) {
            table5.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 6) {
            table6.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 7) {
            table7.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 8) {
            table8.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 9) {
            table9.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 10) {
            table10.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 11) {
            table11.setFill(Paint.valueOf("#1fff4e"));
        }
        if (tableNumber == 12) {
            table12.setFill(Paint.valueOf("#1fff4e"));
        }
    }
    public void bookingSuccessful(){
        try {
            URL url = new File("src/main/ui/bookSuccess.fxml").toURI().toURL();
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
