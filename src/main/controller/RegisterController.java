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

public class RegisterController {
    public RegisterModel registerModel = new RegisterModel();
    @FXML
    private TextField txtEmpID;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAnswer;
    @FXML
    private TextField txtAge;
    @FXML
    private Label labelStatus;
    @FXML
    private TextField txtQuestion;
    @FXML
    private Button buttonRegister;





    public void commitRegister(ActionEvent event){
        SQLConnection.connect();


        try {
            if (registerModel.isRegistered(Integer.parseInt(txtEmpID.getText()), txtUsername.getText()) == true){
                labelStatus.setText("Register failed, already ID/Username");
            }else{
                registerModel.register(Integer.parseInt(txtEmpID.getText()), txtFirstName.getText(), txtLastName.getText(), Integer.parseInt(txtAge.getText()), txtUsername.getText(), txtPassword.getText(), "employee", txtQuestion.getText(), txtAnswer.getText());
                labelStatus.setText("Register successful");
                registrationSuccessful();
                Stage stage = (Stage) buttonRegister.getScene().getWindow();
                stage.close();
            }

        } catch (Exception e) {

        }
    }
    public void registrationSuccessful(){
        try {
            URL url = new File("src/main/ui/registrationsuccessful.fxml").toURI().toURL();
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

