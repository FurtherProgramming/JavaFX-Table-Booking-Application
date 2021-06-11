package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
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
import main.model.AdminAddAccountModel;

public class AdminAddAccountController implements Initializable{ //add employees or admins
    @FXML private Label labelStatus;
    @FXML private TextField txtID;
    @FXML private TextField txtName;
    @FXML private TextField txtSurname;
    @FXML private TextField txtAge;
    @FXML private TextField txtUser;
    @FXML private TextField txtPassword;
    @FXML private ChoiceBox choiceboxRole;
    @FXML private TextField txtQuestion;
    @FXML private TextField txtAnswer;
    @FXML private Button buttonCancel;
    @FXML private Button buttonConfirm;
    private String[] roles = {"employee", "admin"};

    AdminAddAccountModel accountModel = new AdminAddAccountModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceboxRole.getItems().addAll(roles);


    }
    public void register(ActionEvent event){
        SQLConnection.connect();

        try {
            if (accountModel.isRegistered(Integer.parseInt(txtID.getText()), txtUser.getText()) == true){
                labelStatus.setText("Register failed, already ID/Username");
            }else{
                accountModel.register(Integer.parseInt(txtID.getText()), txtName.getText(), txtSurname.getText(), Integer.parseInt(txtAge.getText()), txtUser.getText(), txtPassword.getText(), getRole(), txtQuestion.getText(), txtAnswer.getText());
                labelStatus.setText("Register successful");
                registrationSuccessful();
                Stage stage = (Stage) buttonConfirm.getScene().getWindow();
                stage.close();
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
    public void goToAdminMenu(){
        try {
            URL url = new File("src/main/ui/adminmenu.fxml").toURI().toURL();
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
