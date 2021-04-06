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
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        // test code - Get Country
        //Country co = a.getCountry("GBR");

        // Run Reports
        a.runReport1();
        a.runReport2();
        a.runReport3();
        a.runReport4();
        a.runReport5();
        a.runReport6();
        a.runReport7();
        a.runReport8();
        a.runReport9();
        a.runReport10();
        //a.runReport11();
        //a.runReport12();
        //a.runReport13();
        //a.runReport14();
        //a.runReport15();
        //a.runReport16();
        //a.runReport17();
        //a.runReport18();
        //a.runReport19();
        //a.runReport20();
        //a.runReport21();
        //a.runReport22();
        //a.runReport23();
        //a.runReport24();
        //a.runReport25();

        // Disconnect from database
        a.disconnect();

    }

    /**
     * Test returning Country info
     * @return
     */
    public Country getCountry(String testCode) throws SQLException {
        //Exception Handler for null entry
        if (testCode == null)
        {
            System.out.println("No Country specified");
            return null;
        }
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
     * Report 1
     */
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
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    /**
     * Report 2
     */
    private void runReport2() {
        try {
            // Create variable for user input
            String selCont = JOptionPane.showInputDialog(null, "Please enter the required Continent", "Report 2", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "WHERE Continent = '" +selCont+ "' ORDER BY Population desc;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        String selCont = "";
    }

    /**
     * Report 3
     */
    private void runReport3() {
        try {
            // Create variable for user input
            String selRegion = JOptionPane.showInputDialog(null, "Please enter the required Region", "Report 3", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "WHERE Region = '" +selRegion+ "' ORDER BY Population desc;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        String selRegion = "";
    }

    /**
     * Report 4
     */
    private void runReport4() {
        try {
            // Create variable for user input
            int reqCountries = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of required Countries", "Report 4", JOptionPane.QUESTION_MESSAGE));

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "ORDER BY Population desc\nLIMIT " +reqCountries+ ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        int reqCountries = 0;
    }

    /**
     * Report 5
     */
    private void runReport5() {
        try {
            // Create variable for user input
            int reqCountries = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of required Countries", "Report 5", JOptionPane.QUESTION_MESSAGE));
            String selCont = JOptionPane.showInputDialog(null, "Please enter the required Continent", "Report 5", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "WHERE Continent = '" +selCont+ "'\nORDER BY Population desc\nLIMIT " +reqCountries+ ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        int reqCountries = 0;
        String selCont = "";
    }

    /**
     * Report 6
     */
    private void runReport6() {
        try {
            // Create variable for user input
            int reqCountries = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of required Countries", "Report 6", JOptionPane.QUESTION_MESSAGE));
            String selRegion = JOptionPane.showInputDialog(null, "Please enter the required Region", "Report 6", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital from country\n" +
                    "WHERE Region = '" +selRegion+ "'\nORDER BY Population desc\nLIMIT " +reqCountries+ ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int count = rset.getInt("population");
                int capital = rset.getInt("Capital");
                System.out.println(code + "\t" + name + "\t" + continent + "\t" + region + "\t" + count + "\t" + capital);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        int reqCountries = 0;
        String selRegion = "";
    }

    /**
     * Report 7
     */
    private void runReport7() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT ci.Name, co.Name as 'Country', ci.District, ci.Population from city ci\n" +
                    "JOIN country co on ci.CountryCode = co.Code\nORDER by Population desc";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String name = rset.getString("Name");
                String country = rset.getString("Country");
                String district = rset.getString("District");
                int count = rset.getInt("population");
                System.out.println(name + "\t" + country + "\t" + district + "\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    /**
     * Report 8
     */
    private void runReport8() {
        try {
            // Create variable for user input
            String selCont = JOptionPane.showInputDialog(null, "Please enter the required Continent", "Report 8", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT ci.Name, co.Name as 'Country', ci.District, ci.Population from city ci\n" +
                    "JOIN country co on ci.CountryCode = co.Code\nWHERE Continent = '" +selCont+ "'\nORDER by Population desc";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String name = rset.getString("Name");
                String country = rset.getString("Country");
                String district = rset.getString("District");
                int count = rset.getInt("population");
                System.out.println(name + "\t" + country + "\t" + district + "\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        String selCont = "";
    }

    /**
     * Report 9
     */
    private void runReport9() {
        try {
            // Create variable for user input
            String selRegion = JOptionPane.showInputDialog(null, "Please enter the required Region", "Report 9", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT ci.Name, co.Name as 'Country', ci.District, ci.Population, co.Region from city ci\n" +
                    "JOIN country co on ci.CountryCode = co.Code\nWHERE co.Region = '" + selRegion + "'\nORDER by Population desc";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String name = rset.getString("Name");
                String country = rset.getString("Country");
                String district = rset.getString("District");
                int count = rset.getInt("population");
                System.out.println(name + "\t" + country + "\t" + district + "\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        String selRegion = "";
    }

    /**
     * Report 10
     */
    private void runReport10() {
        try {
            // Create variable for user input
            String selCountry = JOptionPane.showInputDialog(null, "Please enter the required Country", "Report 10", JOptionPane.QUESTION_MESSAGE);

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT ci.Name, co.Name as 'Country', ci.District, ci.Population from city ci\n" +
                    "JOIN country co on ci.CountryCode = co.Code\nWHERE co.Name = '" + selCountry + "'\nORDER by Population desc";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                String name = rset.getString("Name");
                String country = rset.getString("Country");
                String district = rset.getString("District");
                int count = rset.getInt("population");
                System.out.println(name + "\t" + country + "\t" + district + "\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        // Reset Variables
        String selCountry = "";
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