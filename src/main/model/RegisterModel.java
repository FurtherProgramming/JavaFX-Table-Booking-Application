package main.model;

import main.SQLConnection;
import org.sqlite.SQLiteConnection;

import java.sql.*;

public class RegisterModel {

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


        public boolean isRegistered ( int empID, String username) throws SQLException {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Connection connection = this.connect();
            String query1 = "select * from employee where ID = ?";
            String query2 = "select * from employee where username = ?";
            try {
                preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, empID);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return true;
                }
                preparedStatement = connection.prepareStatement(query2);
                preparedStatement.setString(1, username);
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
        public void register (int id, String name, String surname,int age, String username, String password, String role, String question, String answer){

            String query = "INSERT INTO Employee(id, name, surname, age, username, password, role, question, answer) values(?, ?, ?, ?, ?, ?, ?, ?,?)";


            try {
                Connection connection = this.connect();
                PreparedStatement PS = connection.prepareStatement(query);
                PS.setInt(1,id);
                PS.setString(2, name);
                PS.setString(3, surname);
                PS.setInt(4, age);
                PS.setString(5, username);
                PS.setString(6, password);
                PS.setString(7, role);
                PS.setString(8, question);
                PS.setString(9, answer);

                PS.executeUpdate();

            } catch (SQLException e) {

            }


        }
    }


