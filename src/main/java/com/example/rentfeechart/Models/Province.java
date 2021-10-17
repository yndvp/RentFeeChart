package com.example.rentfeechart.Models;

import java.util.Arrays;
import java.util.List;

public class Province {
    /**
     * Instance variables for Province
     */
    private int provinceId;
    private String name;
    private String capital;
    private int population;
    private float area;
    private float gdp;

    /**
     * Province object constructor
     */
    public Province(String name, String capital, int population, float area, float gdp) {
        setName(name);
        setCapital(capital);
        setPopulation(population);
        setArea(area);
        setGdp(gdp);
        provinceId = 0;
    }

    /**
     * Get province id
     */
    public int getProvinceId() {
        return provinceId;
    }

    /**
     * Set province id
     * If id is not greater than, it will throw exception
     */
    public void setProvinceId(int provinceId) {
        if(provinceId > 0)
            this.provinceId = provinceId;
        else
            throw new IllegalArgumentException("provinceId must be greater than 0");
    }

    /**
     * Get name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * If the name is not valid, it will throw exception
     */
    public void setName(String name) {
        List<String> validProvinceNames = Arrays.asList("NL","PE","NS","NB","QC","ON","MB","SK","AB","BC");
        if (validProvinceNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException(String.format("%s is invalid, choose from %s",name,
                    validProvinceNames));
    }

    /**
     * Get capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Set capital
     * If capital name is not valid, it will throw exception
     */
    public void setCapital(String capital) {
        List<String> validCapitalNames = Arrays.asList("Edmonton","Victoria","Winnipeg","Fredericton","St. Johns","Halifax","Toronto","Charlottetown","Quebec City","Regina");
        if (validCapitalNames.contains(capital))
            this.capital = capital;
        else
            throw new IllegalArgumentException(String.format("%s is invalid, choose from %s",capital,
                    validCapitalNames));
    }

    /**
     * Get population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set population
     * If population is not greater than 0, it will throw exception
     */
    public void setPopulation(int population) {
        if(population > 0)
            this.population = population;
        else
            throw new IllegalArgumentException("population must be greater than 0");
    }

    /**
     * Get area
     */
    public float getArea() {
        return area;
    }

    /**
     * Set area
     * If area is not greater than 0, it will throw exception
     */
    public void setArea(float area) {
        if(area > 0)
            this.area = area;
        else
            throw new IllegalArgumentException("area must be greater than 0");
    }

    /**
     * Get gdp
     */
    public float getGdp() {
        return gdp;
    }

    /**
     * Set gdp
     * If gdp is not greater than 0, it will throw exception
     */
    public void setGdp(float gdp) {
        if(gdp > 0)
            this.gdp = gdp;
        else
            throw new IllegalArgumentException("gdp must be greater than 0");
    }
}
