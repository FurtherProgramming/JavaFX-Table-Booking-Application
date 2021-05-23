package main.controller;
import javafx.fxml.FXML;
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
import javafx.stage.Stage;
import main.model.RegisterModel;
import main.SQLConnection;


import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import main.model.ResetPassword1Model;
public class ResetPassword1Controller {
    @FXML
    private Label labelStatus;
    @FXML
    private TextField txtEmpID;
    @FXML
    private Button buttonConfirm;
    private int empID;

    ResetPassword1Model RP1M = new ResetPassword1Model();
    public void checkEmpID(){
        try {
        if (RP1M.validEmployeeID(Integer.parseInt(txtEmpID.getText())) == true){
            setEmpID(Integer.parseInt(txtEmpID.getText()));
            goToResetPassword2();
            Stage stage = (Stage) buttonConfirm.getScene().getWindow();

        }else{
            labelStatus.setText("Invalid ID");
        }

        } catch (Exception e) {

        }

    }

    public void goToResetPassword2(){
        try {
            URL url = new File("src/main/ui/ResetPassword2.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("ResetPassword");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }
    private void setEmpID(int id){

        empID = id;
    }
    public int getEmpID(){
        return empID;
    }

}
