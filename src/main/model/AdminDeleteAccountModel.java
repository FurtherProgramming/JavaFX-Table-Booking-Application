package main.model;
import main.SQLConnection;
import java.sql.*;

public class AdminDeleteAccountModel {

    Connection connection;
    public AdminDeleteAccountModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
    public boolean userExists(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where id = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
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
    public void deleteUser(int id) {

        String query = "delete from employee where id = ?";
        try {

            PreparedStatement PS = connection.prepareStatement(query);
            PS.setInt(1, id);
            PS.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
