package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.SQLException;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void getCountryTestNull() throws SQLException {
        app.getCountry(null);
    }

}