package com.napier.sem;

import java.sql.*;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) {
        App app = new App();
        // Connect to database
        app.connect();

//        app.displayCountries();



        // Disconnect from database
        app.disconnect();
    }

    private void runReport1() {
    }

    private void displayCountries() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            //could break this down into two SQL statements to retrieve employee details using joins
            // then another query to get the manager

            String strSelect = "SELECT * FROM city;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            while (rset.next()) {
                String name = rset.getString("Name");
                int count = rset.getInt("population");
                System.out.println(name + "\t\t" + count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start needed for travis but can be removed locally if db running
                Thread.sleep(30000);

                // Connect to database locally
//                con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=true", "root", "example");

                // Connect to database inside docker
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");

                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                // print
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