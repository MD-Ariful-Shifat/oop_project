package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageBankComplianceReportsController
{
    @javafx.fxml.FXML
    private TableColumn<ManageBankComplianceReports, String> summaryColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageBankComplianceReports, String> reportColumn;
    @javafx.fxml.FXML
    private TextField bankName2;
    @javafx.fxml.FXML
    private TextField bankName1;
    @javafx.fxml.FXML
    private DatePicker dateID1;
    @javafx.fxml.FXML
    private TableColumn<ManageBankComplianceReports, String> submissionDateColumn;
    @javafx.fxml.FXML
    private DatePicker dateID2;
    @javafx.fxml.FXML
    private TextField reportID1;
    @javafx.fxml.FXML
    private TextField reportID2;
    @javafx.fxml.FXML
    private ComboBox<String> statusID;
    @javafx.fxml.FXML
    private TextField reportID3;
    @javafx.fxml.FXML
    private TableColumn<ManageBankComplianceReports, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<ManageBankComplianceReports> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageBankComplianceReports, String> bankColumn;
    @javafx.fxml.FXML
    private TextArea summaryID;
    private List<ManageBankComplianceReports> manageBankComplianceReportsArrayList = new ArrayList<>();
    private File file = new File( "data/ManageBankComplianceReports.bin");

    @javafx.fxml.FXML
    public void initialize() {

        reportColumn.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        submissionDateColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        manageBankComplianceReportsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageBankComplianceReportsArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageBankComplianceReports manageBankComplianceReports = new ManageBankComplianceReports(
                reportID1.getText(),
                dateID1.getValue(),
                bankName1.getText(),
                summaryID.getText(),
                statusID.getValue()

        );

        manageBankComplianceReportsArrayList.add(manageBankComplianceReports);
        BinaryFileHelper.writeAllObjects(file, manageBankComplianceReportsArrayList);
    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageBankComplianceReports cb: manageBankComplianceReportsArrayList){
            if (reportID3.getText().equals(cb.getReportID())){
                manageBankComplianceReportsArrayList.remove(cb);
                break;
            }

        }
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageBankComplianceReports cb: manageBankComplianceReportsArrayList){
            if (reportID2.getText().equals(cb.getReportID())){
                cb.setBankName(bankName2.getText());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageBankComplianceReportsArrayList);
        initialize();
    }

    @javafx.fxml.FXML
    public void signOutt(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "shifat/DirectorofBankingRegulation.fxml", "Sign Out");


    }
}