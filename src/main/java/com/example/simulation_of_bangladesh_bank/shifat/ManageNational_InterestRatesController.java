package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageNational_InterestRatesController
{
    @javafx.fxml.FXML
    private TableColumn<ManageNational_InterestRates, String> rateTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageNational_InterestRates, String> percentageColumn;
    @javafx.fxml.FXML
    private TextField rateID3;
    @javafx.fxml.FXML
    private TextField percentageID2;
    @javafx.fxml.FXML
    private TextField percentageID1;
    @javafx.fxml.FXML
    private ComboBox<String> rateType1;
    @javafx.fxml.FXML
    private TextField rateID1;
    @javafx.fxml.FXML
    private ComboBox<String> rateType2;
    @javafx.fxml.FXML
    private TextField rateID2;
    @javafx.fxml.FXML
    private TableColumn<ManageNational_InterestRates, LocalDate> effectiveDateColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageNational_InterestRates, String> rateColumn;
    @javafx.fxml.FXML
    private TableView<ManageNational_InterestRates> tableID;
    @javafx.fxml.FXML
    private DatePicker effectiveDate;
    private List<ManageNational_InterestRates> manageNational_interestRatesArrayList = new ArrayList<>();
    private File file = new File( "data/ManageNational_InterestRates.bin");

    @javafx.fxml.FXML
    public void initialize() {
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("rateID"));
        rateTypeColumn.setCellValueFactory(new PropertyValueFactory<>("rateType"));
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        effectiveDateColumn.setCellValueFactory(new PropertyValueFactory<>("effectiveDate"));

        manageNational_interestRatesArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageNational_interestRatesArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageNational_InterestRates manageNational_interestRates = new ManageNational_InterestRates(
                rateID1.getText(),
                rateType1.getValue(),
                percentageID1.getText(),
                effectiveDate.getValue()
        );

        manageNational_interestRatesArrayList.add(manageNational_interestRates);
        BinaryFileHelper.writeAllObjects(file, manageNational_interestRatesArrayList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
    }
}