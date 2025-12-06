package com.example.simulation_of_bangladesh_bank.nowshin;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateComplianceReportController
{
    @javafx.fxml.FXML
    private TextField reportID1;
    @javafx.fxml.FXML
    private TextField reportID2;
    @javafx.fxml.FXML
    private TextField reportID21;
    @javafx.fxml.FXML
    private ComboBox<String> durationID;
    @javafx.fxml.FXML
    private DatePicker dateID;
    @javafx.fxml.FXML
    private TableView<GenerateComplianceReport> tableID;
    @javafx.fxml.FXML
    private TableColumn<GenerateComplianceReport, String> submissionColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateComplianceReport, String> reportColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateComplianceReport, String> durationColumn;
    private List<GenerateComplianceReport> generateComplianceReportArrayList = new ArrayList<>();
    private File file = new File( "data/GenerateComplianceReport.bin");

    @javafx.fxml.FXML
    public void initialize() {
        reportColumn.setCellValueFactory(new PropertyValueFactory<>( "reportSl"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>( "duration"));
        submissionColumn.setCellValueFactory(new PropertyValueFactory<>( "date"));


        generateComplianceReportArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(generateComplianceReportArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        GenerateComplianceReport generateComplianceReport = new GenerateComplianceReport(
                reportID1.getText(),
                durationID.getValue(),
                dateID.getValue()


        );

        generateComplianceReportArrayList.add(generateComplianceReport);
        BinaryFileHelper.writeAllObjects(file, generateComplianceReportArrayList);
        generateComplianceReportArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(generateComplianceReportArrayList);
    }

    @javafx.fxml.FXML
    public void searchOnClick(ActionEvent actionEvent) {
        tableID.getItems().clear();
        for (GenerateComplianceReport cb: generateComplianceReportArrayList) {
            if (reportID21.getText().equals(cb.getReportSl())) {
                tableID.getItems().add(cb);
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void signOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (GenerateComplianceReport cb: generateComplianceReportArrayList){
            if (reportID21.getText().equals(cb.getReportSl())){
                generateComplianceReportArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, generateComplianceReportArrayList);
        generateComplianceReportArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(generateComplianceReportArrayList);
    }
}