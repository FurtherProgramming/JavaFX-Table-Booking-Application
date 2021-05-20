package main.model;

import main.SQLConnection;
import org.sqlite.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {

    Connection connection;


    public RegisterModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean isRegisteredID(int empID, String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query1 = "select * from employee where ID = ?";
        String query2 = "select * from employee where username = ?";
        try {
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, empID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            }
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            } else{
                return false;
            }

        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }




    }
    public void Register(int id, String name, String surname, int age, String username, String password, String role, String question, String answer){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = " insert into employee (id, name, surname, age, username, password, role, question, answer, admin)" + " values (?, ?, ?, ?, ?, ?, ?, ?, no)";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, role);
            preparedStatement.setString(8, question);
            preparedStatement.setString(9, answer);

            resultSet = preparedStatement.executeQuery();

        }
        catch (Exception e){

        }


    }
}
