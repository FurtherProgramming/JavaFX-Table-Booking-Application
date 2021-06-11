package main.model;
import java.sql.*;
public class AdminViewDeskModel {
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
    public boolean isLocked(Date date, int seat) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
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
        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();

        }

    }

    public int getUserIDBooking(Date date, int seat)throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = this.connect();
        String query = "select id from booking where date = ? and seat = ?";
        ResultSet resultSet = null;
        int ID;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, seat);
            resultSet = preparedStatement.executeQuery();
            ID = resultSet.getInt(1);
            return ID;

        } catch (Exception e) {
            return 999;
        } finally {
            preparedStatement.close();

        }
    }
    public void lockSeat(Date date, int seat){
        Connection connection = this.connect();
        String query = "insert into booking (id, date, seat) values (0, ?, ?)";
        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setDate(1, date);
            PS.setInt(2, seat);
            PS.executeUpdate();

            connection.close();

        } catch (SQLException e) {



        }



    }
    public void unlockSeat(Date date, int seat){
        Connection connection = this.connect();
        String query = "delete from booking where id = 0 and date = ? and seat = ?";
        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setDate(1, date);
            PS.setInt(2, seat);
            PS.executeUpdate();

            connection.close();

        } catch (SQLException e) {



        }
    }
}
