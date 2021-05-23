package main.model;
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
import java.sql.*;
import java.util.ResourceBundle;

public class ResetPassword1Model {
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:assignment.db");
            return connection;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean validEmployeeID(int empID) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = this.connect();
        String query = "select * from employee where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, empID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        } finally {
        preparedStatement.close();
        resultSet.close();
    }




}
}
