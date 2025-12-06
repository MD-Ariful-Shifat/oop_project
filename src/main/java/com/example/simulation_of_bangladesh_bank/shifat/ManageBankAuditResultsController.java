package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageBankAuditResultsController
{
    @javafx.fxml.FXML
    private TableColumn<ManageBankAuditResults, String> auditDateColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageBankAuditResults, String> auditorNameColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageBankAuditResults, String> summaryColumn;
    @javafx.fxml.FXML
    private TextField bankName2;
    @javafx.fxml.FXML
    private TextField bankName1;
    @javafx.fxml.FXML
    private DatePicker dateID1;
    @javafx.fxml.FXML
    private TextField auditID3;
    @javafx.fxml.FXML
    private TextField auditID2;
    @javafx.fxml.FXML
    private TableColumn<ManageBankAuditResults, String> auditColumn;
    @javafx.fxml.FXML
    private TextField auditID1;
    @javafx.fxml.FXML
    private TableView<ManageBankAuditResults> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageBankAuditResults, String> bankColumn;
    @javafx.fxml.FXML
    private TextArea summaryID;
    @javafx.fxml.FXML
    private TextField auditorName;
    private List<ManageBankAuditResults> manageBankAuditResultsArrayList = new ArrayList<>();
    private File file = new File( "data/ManageBankAuditResults.bin");

    @javafx.fxml.FXML
    public void initialize() {

        auditColumn.setCellValueFactory(new PropertyValueFactory<>("auditID"));
        auditDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        auditorNameColumn.setCellValueFactory(new PropertyValueFactory<>("auditorName"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));

        manageBankAuditResultsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageBankAuditResultsArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageBankAuditResults manageBankAuditResults = new ManageBankAuditResults(
                auditID1.getText(),
                dateID1.getValue(),
                bankName1.getText(),
                auditorName.getText(),
                summaryID.getText()


        );

        manageBankAuditResultsArrayList.add(manageBankAuditResults);
        BinaryFileHelper.writeAllObjects(file, manageBankAuditResultsArrayList);
        manageBankAuditResultsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageBankAuditResultsArrayList);
    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageBankAuditResults cb: manageBankAuditResultsArrayList){
            if (auditID3.getText().equals(cb.getAuditID())){
                manageBankAuditResultsArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, manageBankAuditResultsArrayList);
        manageBankAuditResultsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageBankAuditResultsArrayList);
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageBankAuditResults cb: manageBankAuditResultsArrayList){
            if (auditID2.getText().equals(cb.getAuditID())){
                cb.setBankName(bankName2.getText());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageBankAuditResultsArrayList);
        manageBankAuditResultsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageBankAuditResultsArrayList);
    }

    @javafx.fxml.FXML
    public void signOutt(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }
}