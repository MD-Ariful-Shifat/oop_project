package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageInflationReportsController
{
    @javafx.fxml.FXML
    private TableView<ManageInflationReports> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageInflationReports, String> yearColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageInflationReports, String> inflationColumn;
    @javafx.fxml.FXML
    private TextField inflationID1;
    @javafx.fxml.FXML
    private TextField inflationID2;
    @javafx.fxml.FXML
    private TableColumn<ManageInflationReports, String> reportColumn;
    @javafx.fxml.FXML
    private DatePicker yearID2;
    @javafx.fxml.FXML
    private DatePicker yearID1;
    @javafx.fxml.FXML
    private TextField reportID1;
    @javafx.fxml.FXML
    private TextField reportID2;
    @javafx.fxml.FXML
    private TextField reportID3;
    @javafx.fxml.FXML
    private TextArea commentID;
    @javafx.fxml.FXML
    private TableColumn<ManageInflationReports, String> commentColumn;
    private List<ManageInflationReports> manageInflationReportsArrayList = new ArrayList<>();
    private File file = new File( "data/ManageInflationReports.bin");

    @javafx.fxml.FXML
    public void initialize() {

        reportColumn.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        inflationColumn.setCellValueFactory(new PropertyValueFactory<>("inflationRate"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));


        manageInflationReportsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageInflationReportsArrayList);
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageInflationReports manageInflationReports = new ManageInflationReports(
                reportID1.getText(),
                yearID1.getValue(),
                inflationID1.getText(),
                commentID.getText()
        );

        manageInflationReportsArrayList.add(manageInflationReports);
        BinaryFileHelper.writeAllObjects(file, manageInflationReportsArrayList);
    }

    @Deprecated
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageInflationReports cb: manageInflationReportsArrayList){
            if (reportID3.getText().equals(cb.getReportID())){
                manageInflationReportsArrayList.remove(cb);
                break;
            }

        }
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageInflationReports cb: manageInflationReportsArrayList){
            if (reportID2.getText().equals(cb.getReportID())){
                cb.setYear(yearID2.getValue());
                cb.setInflationRate(inflationID2.getText());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageInflationReportsArrayList);
        initialize();
    }

    @javafx.fxml.FXML
    public void signOutt(ActionEvent actionEvent) throws IOException  {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }
}