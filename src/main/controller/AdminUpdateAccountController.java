package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import main.model.AdminUpdateAccountModel;
public class AdminUpdateAccountController implements Initializable { //able to update details of any account
    AdminUpdateAccountModel updateModel = new AdminUpdateAccountModel();
    @FXML private TextField txtID;
    @FXML private TextField txtName;
    @FXML private TextField txtSurname;
    @FXML private TextField txtAge;
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private TextField txtQuestion;
    @FXML private TextField txtAnswer;
    @FXML private ChoiceBox choiceboxRole;
    @FXML private Button buttonCancel;
    @FXML private Button buttonUpdate;
    @FXML private Label labelStatus;
    private String[] roles = {"employee", "admin"};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceboxRole.getItems().addAll(roles);
    }
    public void Update(ActionEvent event){
        try {
            if (updateModel.idExists(Integer.parseInt(txtID.getText())) == false){
                labelStatus.setText("Update failed, no ID Exists");
            }else{
                updateModel.update(Integer.parseInt(txtID.getText()), txtName.getText(), txtSurname.getText(), Integer.parseInt(txtAge.getText()), txtUsername.getText(), txtPassword.getText(), getRole(), txtQuestion.getText(), txtAnswer.getText());
                labelStatus.setText("Update successful");

            }

        } catch (Exception e) {

        }
    }
    public void Cancel(ActionEvent event){
        goToAdminMenu();
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
    public String getRole(){
        String role = choiceboxRole.getValue().toString();
        return role;
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
