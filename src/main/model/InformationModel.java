package main.model;

import java.sql.*;

public class InformationModel {
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

    private static int id;

    public void setId(int i){
        id = i;
    }

    public int getId(){
        return id;
    }
    public int retrieveID(String username) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = this.connect();
        String query = "select ID from employee where USERNAME = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            id = resultSet.getInt(1);
            return id;

        } catch (Exception e) {
            return 0;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

}
