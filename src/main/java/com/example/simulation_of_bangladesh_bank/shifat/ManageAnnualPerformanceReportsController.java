package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageAnnualPerformanceReportsController
{
    @javafx.fxml.FXML
    private TableColumn<ManageAnnualPerformanceReports, String> yearColumn;
    @javafx.fxml.FXML
    private TextField reportID1;
    @javafx.fxml.FXML
    private TextField reportID2;
    @javafx.fxml.FXML
    private TextField reportID3;
    @javafx.fxml.FXML
    private TableView<ManageAnnualPerformanceReports> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageAnnualPerformanceReports, String> bankColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageAnnualPerformanceReports, String> reportColumn;
    @javafx.fxml.FXML
    private TextField bankName2;
    @javafx.fxml.FXML
    private TableColumn<ManageAnnualPerformanceReports, String> remarkColumn;
    @javafx.fxml.FXML
    private TextField bankName1;
    @javafx.fxml.FXML
    private TextArea remarkID;
    @javafx.fxml.FXML
    private DatePicker yearID;
    private List<ManageAnnualPerformanceReports> manageAnnualPerformanceReportsArrayList = new ArrayList<>();
    private File file = new File( "data/ManageAnnualPerformanceReports.bin");

    @javafx.fxml.FXML
    public void initialize() {

        reportColumn.setCellValueFactory(new PropertyValueFactory<>("report"));
        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        remarkColumn.setCellValueFactory(new PropertyValueFactory<>("remark"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        manageAnnualPerformanceReportsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageAnnualPerformanceReportsArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageAnnualPerformanceReports manageAnnualPerformanceReports = new ManageAnnualPerformanceReports(
                reportID1.getText(),
                bankName1.getText(),
                yearID.getValue(),
                remarkID.getText()


        );

        manageAnnualPerformanceReportsArrayList.add(manageAnnualPerformanceReports);
        BinaryFileHelper.writeAllObjects(file, manageAnnualPerformanceReportsArrayList);
        manageAnnualPerformanceReportsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageAnnualPerformanceReportsArrayList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageAnnualPerformanceReports cb: manageAnnualPerformanceReportsArrayList){
            if (reportID3.getText().equals(cb.getReport())){
                manageAnnualPerformanceReportsArrayList.remove(cb);
                break;
            }

        }
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageAnnualPerformanceReports cb: manageAnnualPerformanceReportsArrayList){
            if (reportID2.getText().equals(cb.getReport())){
                cb.setReport(reportID2.getText());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageAnnualPerformanceReportsArrayList);
        initialize();
    }
}