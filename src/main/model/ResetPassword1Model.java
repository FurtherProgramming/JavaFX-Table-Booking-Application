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
        public String getQuestion(int empID) throws SQLException {
            PreparedStatement preparedStatement = null;
            Connection connection = this.connect();
            String query = "select question from employee where ID = ?";
            ResultSet resultSet = null;
            String question;


            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, empID);
                resultSet = preparedStatement.executeQuery();
                question = resultSet.getString(1);
                return question;

            } catch (Exception e) {
                return null;
            } finally {
                preparedStatement.close();

            }


        }


        public boolean isCorrect(String answer, int empID) throws SQLException {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Connection connection = this.connect();
            String query = "select answer from employee where ID = ?";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, empID);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.getString(1).toLowerCase().compareTo(answer.toLowerCase()) == 0){
                    return true;
                } else{
                    return false;
                }
            }
            catch (Exception e) {
                return false;
            }finally{
                preparedStatement.close();
                resultSet.close();
            }

        }

        public void changePassword(String password, int id) throws SQLException {

            String query = "update employee set password = ? where id = ?";


            try {
                Connection connection = this.connect();
                PreparedStatement PS = connection.prepareStatement(query);
                PS.setString(1, password);
                PS.setString(2, Integer.toString(id));
                PS.executeQuery();


            } catch (Exception e) {

            } finally {

            }


        }




}

