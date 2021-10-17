package com.example.rentfeechart.Controllers;

import com.example.rentfeechart.Models.Province;
import com.example.rentfeechart.Utilities.DBUtilities;
import com.example.rentfeechart.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

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
    private TableColumn<Province, Float> areaColumn;

    @FXML
    private TableColumn<Province, Float> gdpColumn;

    @FXML
    private TableColumn<Province, Integer> rentFeeColumn;

    /**
     * This method populate the table view
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("provinceId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        capitalColumn.setCellValueFactory(new PropertyValueFactory<>("capital"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        gdpColumn.setCellValueFactory(new PropertyValueFactory<>("gdp"));
        rentFeeColumn.setCellValueFactory(new PropertyValueFactory<>("rentFee"));

        tableView.getItems().addAll(DBUtilities.getRentFeesDetails());
    }

    @FXML
    private void viewChart(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "rent-fees-view.fxml", "Rent Fees Chart");
    }
}

