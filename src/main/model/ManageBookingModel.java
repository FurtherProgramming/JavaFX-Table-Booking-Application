package main.model;

import java.sql.*;
import main.SQLConnection;
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
        ResultSet resultSet= null;
        String query = "select date from booking where id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            Date date = resultSet.getDate(1);
            return date;
        } catch (Exception e) {
            return null;
        } finally {
            preparedStatement.close();

        }
    }
    public int getUserBookingSeat(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;
        String query = "select seat from booking where id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            int seat = resultSet.getInt(1);
            return seat;
        } catch (Exception e) {
            return 0;
        } finally {
            preparedStatement.close();

        }
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


}
