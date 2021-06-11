package main.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.SQLConnection;
import org.sqlite.SQLiteConnection;
import java.time.LocalDate;

import java.sql.*;

import java.io.File;
import java.net.URL;

public class BookingModel {
    Connection connection;

    public BookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }


    public boolean isBooked(Date date, int seat) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from Booking where Date = ? and Seat = ?";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, seat);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                }catch (Exception e){

                }
            if (resultSet != null)
                try {
                    resultSet.close();
                }catch (Exception e){

                }
        }

    }

    public void book(int id, Date date, int seat){
        String query = "INSERT INTO Booking(id, Date, Seat) values (?, ?, ?)";

        try {
            PreparedStatement PS = connection.prepareStatement(query);
            PS.setInt(1,id);
            PS.setDate(2, date);
            PS.setInt(3, seat);
            PS.executeUpdate();


        } catch (SQLException e) {

        }


    }
    public boolean isLocked(Date date, int seat) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from Booking where id = 0 and Date = ? and Seat = ?";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, seat);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                }catch (Exception e){

                }
            if (resultSet != null)
                try {
                    resultSet.close();
                }catch (Exception e){

                }
        }

    }

    

    public boolean userAlreadyBooked(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from Booking where id = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

            }
        catch (Exception e)
            {
                return false;
            }finally {
                if (preparedStatement != null)
                    try {
                        preparedStatement.close();
                    }catch (Exception e){

                    }
                if (resultSet != null)
                    try {
                        resultSet.close();
                    }catch (Exception e){

                    }
            }

        }
}
