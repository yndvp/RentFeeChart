package com.example.rentfeechart.Controllers;

import com.example.rentfeechart.Utilities.DBUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.net.URL;
import java.util.ResourceBundle;

public class RentFeesViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis provinceAxis;

    @FXML
    private NumberAxis feesAxis;

    /**
     * Get data from DB and display it on the chart
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtilities.getRentFeesByProvince());
        barChart.setLegendVisible(false);
    }
}
