package com.example.rentfeechart.Utilities;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtilities {
    private static String user ="student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaProjects";

    public static XYChart.Series<String, Integer> getRentFeesByProvince()
    {
        XYChart.Series<String, Integer> rentFeesData = new XYChart.Series<>();

        String sql = "SELECT name AS 'Province', ROUND(AVG(fee)) AS 'Rent Fees'\n" +
                "    FROM provinces INNER JOIN rentFees ON provinces.provinceId = rentFees.provinceId\n" +
                "    GROUP BY provinces.provinceId;";

        try(
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
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
