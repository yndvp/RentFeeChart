package com.example.rentfeechart.Utilities;

import com.example.rentfeechart.Models.Province;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtilities {
    /**
     * Declare account info to connect database
     */
    private static String user ="student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaProjects";

    /**
     * This method makes connection with database, execute the specified query and store the data in the object to display chart
     */
    public static XYChart.Series<String, Integer> getRentFeesByProvince()
    {
        XYChart.Series<String, Integer> rentFeesData = new XYChart.Series<>();

        String sql = "SELECT name AS 'Province', ROUND(AVG(fee)) AS 'Rent Fees'\n" +
                "    FROM provinces INNER JOIN rentFees ON provinces.provinceId = rentFees.provinceId\n" +
                "    GROUP BY provinces.provinceId;";

        // Try-with-resources ensures that anything opened in the brackets will be closed
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            // Load each row of data to rentFeesData object
            while(resultSet.next())
            {
                rentFeesData.getData().add(new XYChart.Data<>(resultSet.getString("Province"), resultSet.getInt("Rent Fees")));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return rentFeesData;
    }

    /**
     * This method makes connection with database, execute the specified query and store the data in the arraylist object to display table
     */
    public static ArrayList<Province> getRentFeesDetails()
    {
        ArrayList<Province> provinces = new ArrayList<>();

        String sql = "SELECT provinces.provinceId, name, capital, population, area, gdp, ROUND(AVG(fee)) AS 'Rent Fee' \n" +
                "FROM provinces INNER JOIN rentFees ON provinces.provinceId = rentFees.provinceId \n" +
                "GROUP BY provinces.provinceId;";

        // Try-with-resources ensures that anything opened in the brackets will be closed
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            // Load each row of data to rentFeesData object
            while(resultSet.next())
            {
                int provinceId = resultSet.getInt("provinceId");
                String name = resultSet.getString("name");
                String capital = resultSet.getString("capital");
                int population = resultSet.getInt("population");
                float area = resultSet.getFloat("area");
                float gdp = resultSet.getFloat("gdp");
                int rentFee = resultSet.getInt("Rent Fee");

                Province province = new Province(name,capital,population,area,gdp,rentFee);
                province.setProvinceId(provinceId);

                provinces.add(province);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return provinces;
    }
}
