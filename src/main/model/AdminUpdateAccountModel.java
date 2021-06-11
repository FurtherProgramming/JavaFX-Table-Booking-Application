package main.model;
import main.SQLConnection;

import java.sql.*;
public class AdminUpdateAccountModel {
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
    public boolean idExists(int id) throws SQLException{
        Connection connection = this.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where id =  ?";

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
    public void update(int id, String name, String surname,int age, String username, String password, String role, String question, String answer){
        String query = "Update employee set name = ?, surname = ?, age = ?, username = ?, password = ?, role = ?, question = ?, answer = ? where id = ?";

            try {
                Connection connection = this.connect();
                PreparedStatement PS = connection.prepareStatement(query);
                PS.setString(1, name);
                PS.setString(2, surname);
                PS.setInt(3, age);
                PS.setString(4, username);
                PS.setString(5, password);
                PS.setString(6, role);
                PS.setString(7, question);
                PS.setString(8, answer);
                PS.setInt(9, id);
                PS.executeUpdate();


            } catch (SQLException e) {

            }


        }

}
