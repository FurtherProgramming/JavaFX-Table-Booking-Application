package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.MenuItem;
import main.model.RegisterModel;



import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController {
    public RegisterModel registerModel = new RegisterModel();
    @FXML
    private Label empID;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label role;
    @FXML
    private Label secretQuestion;
    @FXML
    private Label answer;
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
    private TextField txtRole;
    @FXML
    private TextField txtAnswer;
    @FXML
    private SplitMenuButton menuQuestion;
    @FXML
    private MenuItem question1;
    @FXML
    private MenuItem question2;

    public void Register (ActionEvent event){
        try {
            if ()
        }


    }
}

