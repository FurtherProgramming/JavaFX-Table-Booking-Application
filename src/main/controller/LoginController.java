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
import main.model.InformationModel;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    public InformationModel informationModel = new InformationModel();
    @FXML
    private Label isConnected;
    @FXML
    public TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button buttonForgotPassword;
    @FXML
    private Button buttonLogin;


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
    public void Login(ActionEvent event){ //login

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())) {
                isConnected.setText("Logged in successfully");
                if (loginModel.getAccType(txtUsername.getText()).equals("employee")) {
                    informationModel.setId(informationModel.retrieveID(txtUsername.getText()));
                    goToEmployeeMenu();
                    Stage stage = (Stage) buttonLogin.getScene().getWindow();
                    stage.close();

                }
                if (loginModel.getAccType(txtUsername.getText()).equals("admin")) {
                    informationModel.setId(informationModel.retrieveID(txtUsername.getText()));
                    informationModel.setRole(informationModel.retrieveRole(txtUsername.getText()));
                    goToAdminMenu();
                    Stage stage = (Stage) buttonLogin.getScene().getWindow();
                    stage.close();
                }


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
    public void goToEmployeeMenu(){
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
    public void goToAdminMenu(){
        try {
            URL url = new File("src/main/ui/adminmenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Admin Menu");
            viewStage.setScene(scene);
            viewStage.show();
        } catch(Exception e) {

        }
    }


}






    //11.2.3 big sur




