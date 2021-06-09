package main.model;

import java.sql.*;

public class ManageAccountModel {
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

    public String retrieveQuestion(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select question from employee where ID = ?";
        ResultSet resultSet = null;
        String question;


        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            question = resultSet.getString(1);
            return question;

        } catch (Exception e) {
            return null;
        } finally {
            preparedStatement.close();

        }


    }
    public String retrieveAnswer(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select answer from employee where ID = ?";
        ResultSet resultSet = null;
        String question;


        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            question = resultSet.getString(1);
            return question;

        } catch (Exception e) {
            return null;
        } finally {
            preparedStatement.close();

        }


    }
    public void updateQA(String question, String answer, int id){
        Connection connection = this.connect();
        String query = "update employee set question = ?, answer = ? where id = ?";


        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setString(1, question);
            PS.setString(2, answer);
            PS.setString(3,Integer.toString(id));
            PS.executeUpdate();

            connection.close();
        } catch (SQLException e) {



        }



    }
    public void updatePassword(String password, int id){
        Connection connection = this.connect();
        String query = "update employee set password = ? where id = ?";


        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setString(1, password);
            PS.setString(2, Integer.toString(id));
            PS.executeUpdate();

            connection.close();
        } catch (SQLException e) {



        }
    }


}
