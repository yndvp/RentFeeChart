package com.example.rentfeechart.Models;

import java.util.Arrays;
import java.util.List;

public class Province {
    private int provinceId;
    private String name;
    private String capital;
    private float population;
    private float area;
    private float gdp;

    public Province(int provinceId, String name, String capital, float population, float area, float gdp) {
        this.provinceId = provinceId;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        if(provinceId > 0)
            this.provinceId = provinceId;
        else
            throw new IllegalArgumentException("provinceId must be greater than 0");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        List<String> validProvinceNames = Arrays.asList("NT","BC","AB","SK","MB","ON","QC","NB","NL","NS");
        if (validProvinceNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException(String.format("%s is invalid, choose from %s",name,
                    validProvinceNames));
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        List<String> validCapitalNames = Arrays.asList("Edmonton","Victoria","Winnipeg","Fredericton","St. John's","Halifax","Toronto","Charlottetown","Quebec City","Regina");
        if (validCapitalNames.contains(capital))
            this.capital = capital;
        else
            throw new IllegalArgumentException(String.format("%s is invalid, choose from %s",capital,
                    validCapitalNames));
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        if(population > 0)
            this.population = population;
        else
            throw new IllegalArgumentException("population must be greater than 0");
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        if(area > 0)
            this.area = area;
        else
            throw new IllegalArgumentException("area must be greater than 0");
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        if(gdp > 0)
            this.gdp = gdp;
        else
            throw new IllegalArgumentException("gdp must be greater than 0");
    }
}
