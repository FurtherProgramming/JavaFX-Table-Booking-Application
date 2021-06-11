package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.model.ManageAccountModel;
import main.model.InformationModel;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ManageAccountController implements Initializable{ //employee is able to update their password, question and answer
    ManageAccountModel MAM = new ManageAccountModel();
    InformationModel informationModel = new InformationModel();
    @FXML
    private Label labelQuestion;
    @FXML
    private Label labelAnswer;
    @FXML
    private Label labelStatus;
    @FXML
    private TextField txtQuestion;
    @FXML
    private TextField txtAnswer;
    @FXML
    private PasswordField txtPassword1;
    @FXML
    private PasswordField txtPassword2;
    @FXML
    private Button buttonUpdateQA;
    @FXML
    private Button buttonUpdatePW;
    @FXML
    private Button buttonCancel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      getDetails();


    }
    public void getDetails() {
        try {

                labelQuestion.setText(MAM.retrieveQuestion(informationModel.getId()));
                labelAnswer.setText(MAM.retrieveAnswer(informationModel.getId()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDetails(){
        try {
            if (txtQuestion.getText().isEmpty() || txtAnswer.getText().isEmpty()) {
                labelStatus.setText("Must fill in both question and answer fields");
            }else {
                MAM.updateQA(txtQuestion.getText(), txtAnswer.getText(), informationModel.getId());
                labelStatus.setText("Successfully changed question and answer");
                txtQuestion.setText("");
                txtAnswer.setText("");
                getDetails();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePassword(){
        try {
            if (txtPassword1.getText().equals(txtPassword2.getText()) == false) {
                labelStatus.setText("Password must match");
            if (txtPassword1.getText().isEmpty() || txtPassword2.getText().isEmpty()){
                labelStatus.setText("Must fill in both password fields");
            }
                if (txtPassword1.getText().isEmpty() && txtPassword2.getText().isEmpty()) {
                    labelStatus.setText("Must fill in both password fields");
                }
            } else {
                MAM.updatePassword(txtPassword1.getText(), informationModel.getId());
                labelStatus.setText("Password successfully changed");
                txtPassword1.setText("");
                txtPassword2.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToMenu() {
        try {
            openMenu();
            Stage stage = (Stage) buttonCancel.getScene().getWindow();
            stage.close();
        } catch (Exception e) {


        }
    }
    public void openMenu() {
        try {
            URL url = new File("src/main/ui/employeeMenu.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage viewStage = new Stage();
            Scene scene = new Scene(root);
            viewStage.setTitle("Booking");
            viewStage.setScene(scene);
            viewStage.show();
        } catch (Exception e) {

        }
    }





}