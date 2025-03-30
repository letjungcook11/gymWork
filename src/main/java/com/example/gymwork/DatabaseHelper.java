package com.example.gymwork;

import java.io.IOException;
import java.sql.*;

public class DatabaseHelper {
    private static final String url = "jdbc:mysql://localhost:3306/gymWork";
    private static final String user = "root";
    private static final String pass = "";

    public static void saveUserToDatabase(String userName, String password, String name, String age) throws SQLException {
        String insertSQL = "INSERT INTO gymMember (userName,password,name,age) values (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)){


            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, (Integer.parseInt(age)));

            preparedStatement.executeUpdate();
            System.out.println("Successfully added a new gym member!");
        }
    }

    public static void deleteUserFromDatabase(String userName) throws IOException, SQLException {
        String deleteSQL = "DELETE FROM quiz WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)){

            preparedStatement.setString(1, userName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected >= 1){
                System.out.println("Successfully deleted the user!");
            }
        }
    }

    public static void updateFromDatabase(String workoutName) throws IOException, SQLException{
        String updateSQL = "UPDATE gymWork SET trainer=? WHERE workoutName=?";

        try (Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement preparedStatement =connection.prepareStatement(updateSQL)
        ){

            preparedStatement.setString(1,workoutName);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected >= 1){
                System.out.println("Successfully updated the workout list!");
            }
        }
    }

    public static ResultSet readFromDatabase(String trainerName) throws SQLException, IOException {
        String retrieveSQL = "SELECT * FROM gymWork where trainer=?";

        try(Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement preparedStatement = connection.prepareStatement(retrieveSQL)){

            preparedStatement.setString(1, trainerName);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Something's wrong when retrieving !");
        }
        return null;
    }

    public static boolean readLoginFromDatabase(String searchUsername, String passWord) throws SQLException, IOException{
        String retrieveSQL = "SELECT * FROM gymMember where username=?";

        try(Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement preparedStatement = connection.prepareStatement(retrieveSQL)){

            preparedStatement.setString(1,searchUsername);

            ResultSet row = preparedStatement.executeQuery();
            while(row.next()){
                String memberPassword = row.getString("password");
                return memberPassword.equals(passWord);
            }
                return false;

        }

    }




}
