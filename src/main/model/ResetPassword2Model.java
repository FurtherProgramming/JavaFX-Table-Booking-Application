package main.model;

import java.sql.*;

import main.controller.ResetPassword1Controller;

public class ResetPassword2Model {
    ResetPassword1Controller RP1C = new ResetPassword1Controller();

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

    public String getQuestion() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select question from employee where ID = ?";
        ResultSet resultSet = null;


        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, RP1C.getEmpID());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();


        } catch (Exception e) {

        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return resultSet.getString(1);

    }


    public boolean isCorrect(String answer) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = this.connect();
        String query = "select answer from employee where ID = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, RP1C.getEmpID());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getString(1).toLowerCase() == answer.toLowerCase()){
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
    }

