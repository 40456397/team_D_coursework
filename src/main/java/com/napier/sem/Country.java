package com.napier.sem;

/**
 * Represents a country
 */
public class Country
{
    /**
     * Country code - GBR
     */
    public String code;

    /**
     * Country name - United Kingdom
     */
    public String name;

    /**
     * Country continent - Europe
     */
    public String continent;

    /**
     * Country capital - 456
     */
    public int capital;


    public Country () {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

}
