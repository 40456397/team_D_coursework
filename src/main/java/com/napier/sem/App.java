package com.napier.sem;

import java.sql.*;
import javax.swing.*;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;


    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get Country
        Country co = a.getCountry("GBR");

        // Run Report1
        a.runReport1();

        // Run Report2
        a.runReport2();

        // Disconnect from database
        a.disconnect();

    }
    private void runReport2() {
        try {
            // Create variable for user input
            String selCont = JOptionPane.showInputDialog(null, "Please enter the required Continent");

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "WHERE Continent = '" +selCont+ "', ORDER BY Population desc;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(name + "\t\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    private void runReport1() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            //could break this down into two SQL statements to retrieve employee details using joins
            // then another query to get the manager

            String strSelect = "select Code, Name, Continent, Region, Population, Capital from country order by population desc;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(name + "\t\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    /**
     * Test returning Country info
     * @return
     */
    public Country getCountry(String testCode) throws SQLException {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Capital FROM country WHERE Code = '" + testCode + "';";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country co = new Country();
                co.code = rset.getString("Code");
                co.name = rset.getString("Name");
                co.continent = rset.getString("Continent");
                co.capital = rset.getInt("Capital");
                return co;
            }
            else
                return null;

    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}