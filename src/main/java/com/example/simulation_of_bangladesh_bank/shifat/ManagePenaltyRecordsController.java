package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagePenaltyRecordsController
{
    @javafx.fxml.FXML
    private TableColumn<ManagePenaltyRecords, String> penaltyColumn;
    @javafx.fxml.FXML
    private TableColumn<ManagePenaltyRecords, String> reasonColumn;
    @javafx.fxml.FXML
    private TableColumn<ManagePenaltyRecords, String> amountColumn;
    @javafx.fxml.FXML
    private TextField penaltyID1;
    @javafx.fxml.FXML
    private TextField bankName2;
    @javafx.fxml.FXML
    private TextField penaltyID3;
    @javafx.fxml.FXML
    private TextField bankName1;
    @javafx.fxml.FXML
    private TextField penaltyID2;
    @javafx.fxml.FXML
    private TextField amountID1;
    @javafx.fxml.FXML
    private TableColumn<ManagePenaltyRecords, String> nameColumn;
    @javafx.fxml.FXML
    private TextField reasonID;
    @javafx.fxml.FXML
    private DatePicker dateID;
    @javafx.fxml.FXML
    private TableView<ManagePenaltyRecords> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManagePenaltyRecords, String> dateColumn;
    private List<ManagePenaltyRecords> managePenaltyRecordsArrayList = new ArrayList<>();
    private File file = new File( "data/ManagePenaltyRecords.bin");

    @javafx.fxml.FXML
    public void initialize() {
        penaltyColumn.setCellValueFactory(new PropertyValueFactory<>("penaltyID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("fineAmount"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateIssued"));

        managePenaltyRecordsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(managePenaltyRecordsArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManagePenaltyRecords managePenaltyRecords = new ManagePenaltyRecords(
                penaltyID1.getText(),
                bankName1.getText(),
                amountID1.getText(),
                reasonID.getText(),
                dateID.getValue()


        );

        managePenaltyRecordsArrayList.add(managePenaltyRecords);
        BinaryFileHelper.writeAllObjects(file, managePenaltyRecordsArrayList);
        managePenaltyRecordsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(managePenaltyRecordsArrayList);
    }

    @javafx.fxml.FXML
    public void searchOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
    }
}