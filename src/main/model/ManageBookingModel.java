package main.model;

import java.sql.*;
public class ManageBookingModel {
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
    public Date getUserBookingDate(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select date from booking where ID = ?";
        ResultSet resultSet = null;
        Date date;


        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            date = resultSet.getDate(1);
            return date;

        } catch (Exception e) {
            return null;
        } finally {
            preparedStatement.close();

        }
    }
    public int getUserBookingSeat(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select seat from booking where ID = ?";
        ResultSet resultSet = null;
        int Seat;


        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Seat = resultSet.getInt(1);
            return Seat;

        } catch (Exception e) {
            return 0;
        } finally {
            preparedStatement.close();

        }
    }
    public boolean isBooked(Date date, int seat) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
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
        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();

        }

    }
    public void deleteBooking(int id) {
        Connection connection = this.connect();
        String query = "delete from booking where id = ?";


        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setInt(1, id);
            PS.executeUpdate();

            connection.close();

        } catch (SQLException e) {



        }



    }


}
