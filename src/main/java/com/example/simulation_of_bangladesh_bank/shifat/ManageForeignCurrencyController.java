package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageForeignCurrencyController
{
    @javafx.fxml.FXML
    private ComboBox<String> currencyType1;
    @javafx.fxml.FXML
    private ComboBox<String> currencyType2;
    @javafx.fxml.FXML
    private TableColumn<ManageForeignCurrency, String> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageForeignCurrency, String> reserveColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageForeignCurrency, String> updatedDateColumn;
    @javafx.fxml.FXML
    private TextField amountID1;
    @javafx.fxml.FXML
    private DatePicker lastUpdatedDate;
    @javafx.fxml.FXML
    private TextField amountID2;
    @javafx.fxml.FXML
    private TableView<ManageForeignCurrency> tableID;
    @javafx.fxml.FXML
    private TextField reserveID3;
    @javafx.fxml.FXML
    private TextField reserveID2;
    @javafx.fxml.FXML
    private TextField reserveID1;
    @javafx.fxml.FXML
    private TableColumn<ManageForeignCurrency, String> currencyTypeColumn;
    private List<ManageForeignCurrency> manageForeignCurrencyArrayListList = new ArrayList<>();
    private File file = new File( "data/ManageForeignCurrency.bin");

    @javafx.fxml.FXML
    public void initialize() {
        reserveColumn.setCellValueFactory(new PropertyValueFactory<>("reserveID"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        currencyTypeColumn.setCellValueFactory(new PropertyValueFactory<>("currencyType"));
        updatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        currencyType1.getItems().addAll(" USD", "EUR","JPY", "BDT");
        currencyType2.getItems().addAll(" USD", "EUR","JPY", "BDT");

        manageForeignCurrencyArrayListList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageForeignCurrencyArrayListList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageForeignCurrency cb: manageForeignCurrencyArrayListList){
            if (reserveID3.getText().equals(cb.getReserveID())){
                manageForeignCurrencyArrayListList.remove(cb);
                break;
            }

        }
    }

    @javafx.fxml.FXML
    public void saveOnClick(ActionEvent actionEvent) {
        ManageForeignCurrency manageForeignCurrency = new ManageForeignCurrency(
                reserveID1.getText(),
                amountID1.getText(),
                currencyType1.getValue(),
                lastUpdatedDate.getValue()


        );

        manageForeignCurrencyArrayListList.add(manageForeignCurrency);
        BinaryFileHelper.writeAllObjects(file, manageForeignCurrencyArrayListList);
        manageForeignCurrencyArrayListList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageForeignCurrencyArrayListList);
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageForeignCurrency cb: manageForeignCurrencyArrayListList){
            if (reserveID2.getText().equals(cb.getReserveID())){
                cb.setAmount(amountID2.getText());
                cb.setCurrencyType(currencyType2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageForeignCurrencyArrayListList);
        initialize();
    }
}