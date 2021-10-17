package com.example.rentfeechart.Utilities;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtilities {
    /**
     * Declare account info to connect database
     */
    private static String user ="student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaProjects";

    /**
     * This method makes connection with database, execute the specified query and get the result
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
}
