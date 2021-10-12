package com.example.rentfeechart.Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class RentFeesViewController {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis provinceAxis;

    @FXML
    private NumberAxis feesAxis;

}
