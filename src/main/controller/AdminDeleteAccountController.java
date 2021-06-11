package main.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.SQLConnection;


import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import main.model.AdminDeleteAccountModel;
public class AdminDeleteAccountController { //delete any account
    @FXML private Label labelStatus;
    @FXML private TextField txtID;
    @FXML private Button buttonCancel;
    @FXML private Button buttonDelete;
    AdminDeleteAccountModel deleteModel = new AdminDeleteAccountModel();

    public void delete(ActionEvent event) {
        SQLConnection.connect();

        try {
            if (deleteModel.userExists(Integer.parseInt(txtID.getText())) == false) {
                labelStatus.setText("User does not exist");
            } else {
                deleteModel.deleteUser(Integer.parseInt(txtID.getText()));
                labelStatus.setText("Deleted user " + txtID.getText());
                txtID.setText("");
            }

        } catch (Exception e) {

        }
    }

    public void cancel(ActionEvent event){
            goToAdminMenu();
            Stage stage = (Stage) buttonCancel.getScene().getWindow();
            stage.close();

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
