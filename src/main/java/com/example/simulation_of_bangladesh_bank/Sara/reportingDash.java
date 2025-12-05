package com.example.simulation_of_bangladesh_bank.Sara;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class reportingDash {
    @javafx.fxml.FXML
    private TextField currencyField;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn exchangetableView;
    @javafx.fxml.FXML
    private TextField valueField;
    @javafx.fxml.FXML
    private PieChart piechart;
    @javafx.fxml.FXML
    private TableColumn buyrateTableView;

    @javafx.fxml.FXML
    public void enterbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutButton(ActionEvent actionEvent) throws IOException {
        SceneSwitching.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");
    }
}
