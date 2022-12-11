//============================================================================
// Name        : Database.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Database class that initializes a database and allows the user
//               to insert, search, and delete entries from the database
//============================================================================
package com.chase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;

import org.apache.ibatis.jdbc.ScriptRunner;

public class Database {
    static final String DBURL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "admin";

    public static void initDatabase() {
        // tries to connect to the MySQL database
        try {
            Connection connection = DriverManager.getConnection(DBURL, USER, PASS);
            System.out.println("Connection established");

            // Creates a script runner instance to run the .sql script to create a database and tables
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader("C:\\Users\\Chase\\Desktop\\javasql\\src\\com\\chase\\SQLscript.sql"));
            sr.runScript(reader);

            System.out.println("Database and tables initialized");

            CSVLoader.loadBids("com\\eBid_Monthly_Sales_Dec_2016.csv");

        }
        catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //function that inserts data into the database
    public static void insertData(int bidId, String title, String fund, String amount) {
        //tries to connect to the database
        try (Connection connection = DriverManager.getConnection(DBURL, USER, PASS);
             Statement statement = connection.createStatement();
             ) {
            //use the correct database
            String sql = "USE ebay_records";
            statement.executeUpdate(sql);
            //SQL query to insert data into the ebay_records table
            sql = String.format("INSERT INTO `ebay_records`.`ebay_bids` (`bid_id`, `title`, `fund`, `bid_amount`) VALUES ('%d', '%s', '%s', '%s');",
                                bidId, title, fund, amount);
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //function to print data from the database
    public static void printData() {
        //tries to connect to the database
        try (Connection connection = DriverManager.getConnection(DBURL, USER, PASS);
             Statement statement = connection.createStatement();
        ) {
            //result set to hold the data from a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ebay_records.ebay_bids");
            //while loop to loop through each line of the result and then print certain columns from the table
            while (resultSet.next()) {
                System.out.println(resultSet.getString("bid_id") + " " +
                                   resultSet.getString("title") + " " +
                                   resultSet.getString("bid_amount"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //function that performs a SQL query to find a specific bid
    public static void findBid(String bid_id) {
        try (Connection connection = DriverManager.getConnection(DBURL, USER, PASS);) {
            //search for specific bid given by the user
            String sqlQuery = "SELECT * FROM ebay_records.ebay_bids WHERE bid_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, bid_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //outputs the data of the search
            if (!resultSet.next()) {
                System.out.println("Bid not found!");
            }
            else {
                do {
                    System.out.println(resultSet.getString("bid_id") + " " +
                            resultSet.getString("title") + " " +
                            resultSet.getString("bid_amount"));
                } while (resultSet.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //function that performs a SQL query to remove a specific bid
    public static void removeBid(String bid_id) {
        try (Connection connection = DriverManager.getConnection(DBURL, USER, PASS);) {

            String sqlQuery = "DELETE FROM ebay_records.ebay_bids WHERE bid_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, bid_id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
