package com.example.rentfeechart.Controllers;

import com.example.rentfeechart.Models.Province;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewController {

    @FXML
    private TableView<Province> tableView;

    @FXML
    private TableColumn<Province, Integer> idColumn;

    @FXML
    private TableColumn<Province, String> nameColumn;

    @FXML
    private TableColumn<Province, String> capitalColumn;

    @FXML
    private TableColumn<Province, Integer> populationColumn;

    @FXML
    private TableColumn<Province, Double> areaColumn;

    @FXML
    private TableColumn<Province, Double> gdpColumn;

    @FXML
    private TableColumn<Province, Integer> rentFeeColumn;

}

