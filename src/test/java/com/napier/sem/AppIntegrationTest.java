package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testCountry() throws SQLException {
        Country co = app.getCountry("GBR");
        assertEquals(co.name, "United Kingdom");
        assertEquals(co.code, "GBR");
        assertEquals(co.capital, 456);
    }

}