package com.example.simulation_of_bangladesh_bank.nowshin;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitorTransactionIntegrityController
{
    @javafx.fxml.FXML
    private TextField reportID2;
    @javafx.fxml.FXML
    private ComboBox<String> durationID;
    @javafx.fxml.FXML
    private DatePicker dateID;
    @javafx.fxml.FXML
    private TableView<MonitorTransactionIntegrity> tableID;
    @javafx.fxml.FXML
    private TableColumn<MonitorTransactionIntegrity, String> submissionColumn;
    @javafx.fxml.FXML
    private TableColumn<MonitorTransactionIntegrity, String> reportColumn;
    @javafx.fxml.FXML
    private TableColumn<MonitorTransactionIntegrity, String> durationColumn;
    private List<MonitorTransactionIntegrity> monitorTransactionIntegrityArrayList = new ArrayList<>();
    private File file = new File( "data/MonitorTransactionIntegrity.bin");
    @javafx.fxml.FXML
    private TextField reportID1;


    @javafx.fxml.FXML
    public void initialize() {
        reportColumn.setCellValueFactory(new PropertyValueFactory<>( "reportSl"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>( "duration"));
        submissionColumn.setCellValueFactory(new PropertyValueFactory<>( "date"));


        monitorTransactionIntegrityArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(monitorTransactionIntegrityArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        MonitorTransactionIntegrity monitorTransactionIntegrity = new MonitorTransactionIntegrity(
                reportID1.getText(),
                durationID.getValue(),
                dateID.getValue()


        );

        monitorTransactionIntegrityArrayList.add(monitorTransactionIntegrity);
        BinaryFileHelper.writeAllObjects(file, monitorTransactionIntegrityArrayList);
        monitorTransactionIntegrityArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(monitorTransactionIntegrityArrayList);
    }

    @javafx.fxml.FXML
    public void signOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (MonitorTransactionIntegrity cb: monitorTransactionIntegrityArrayList){
            if (reportID2.getText().equals(cb.getReportSl())){
                monitorTransactionIntegrityArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, monitorTransactionIntegrityArrayList);
        monitorTransactionIntegrityArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(monitorTransactionIntegrityArrayList);
    }

}