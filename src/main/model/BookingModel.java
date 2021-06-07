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

    public boolean isBooked(Date date, int seat) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select seat from Booking where date = ? and seat = ?";

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
            preparedStatement.close();
            resultSet.close();
        }

    }

    public void book(int id, Date date, int seat){
        String query = "INSERT INTO Booking(id, Date, Seat) values (?, ?, ?)";

        try {
            Connection connection = this.connect();
            PreparedStatement PS = connection.prepareStatement(query);
            PS.setInt(1,id);
            PS.setDate(2, date);
            PS.setInt(3, seat);
            PS.executeUpdate();


        } catch (SQLException e) {

        }


    }



}
