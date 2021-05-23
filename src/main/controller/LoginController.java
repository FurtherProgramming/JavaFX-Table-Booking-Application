package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.model.LoginModel;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button buttonForgotPassword;


    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }
    /* login Action method
       check if user input is the same as database.
     */
    public void Login(ActionEvent event){

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())){

                isConnected.setText("Logged in successfully");
            }else{
                isConnected.setText("username and password is incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goToResetPassword(ActionEvent event){
                ResetPassword();
                Stage stage = (Stage) buttonForgotPassword.getScene().getWindow();
                stage.close();

    }
    public void ResetPassword(){
        try {
            URL url = new File("src/main/ui/ResetPassword1.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Reset Password");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }
}






    //11.2.3 big sur




