package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageInspectionSchedulesController
{
    @javafx.fxml.FXML
    private DatePicker inspectionDate2;
    @javafx.fxml.FXML
    private ComboBox<String> StatusID2;
    @javafx.fxml.FXML
    private ComboBox<String> StatusID1;
    @javafx.fxml.FXML
    private TableColumn<ManageInspectionSchedules, String> inspectionColumn;
    @javafx.fxml.FXML
    private TextField bankName2;
    @javafx.fxml.FXML
    private TextField bankName1;
    @javafx.fxml.FXML
    private TextField inspectorName;
    @javafx.fxml.FXML
    private TextField inspectionID2;
    @javafx.fxml.FXML
    private TextField inspectionID1;
    @javafx.fxml.FXML
    private TableColumn<ManageInspectionSchedules, String> inspectorNameColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageInspectionSchedules, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageInspectionSchedules, String> statusColumn;
    @javafx.fxml.FXML
    private TextField inspectionID3;
    @javafx.fxml.FXML
    private TableView<ManageInspectionSchedules> tableview;
    @javafx.fxml.FXML
    private TableColumn<ManageInspectionSchedules, String> dateColumn;
    @javafx.fxml.FXML
    private DatePicker inspectionDate;
    @javafx.fxml.FXML
    private TextField inspectorName2;
    private List<ManageInspectionSchedules> manageInspectionSchedulesArrayList = new ArrayList<>();
    private File file = new File( "data/ManageInspectionSchedule.bin");

    @javafx.fxml.FXML
    public void initialize() {
        inspectionColumn.setCellValueFactory(new PropertyValueFactory<>("inspectionID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        inspectorNameColumn.setCellValueFactory(new PropertyValueFactory<>("inspectorName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        StatusID1.getItems().addAll("Planned", "Completed", "Cancelled");
        StatusID2.getItems().addAll("Planned", "Completed", "Cancelled");


        manageInspectionSchedulesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageInspectionSchedulesArrayList);
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        ManageInspectionSchedules manageInspectionSchedules = new ManageInspectionSchedules(
                inspectionID1.getText(),
                bankName1.getText(),
                inspectionDate.getValue(),
                inspectorName.getText(),
                StatusID1.getValue()


        );

        manageInspectionSchedulesArrayList.add(manageInspectionSchedules);
        BinaryFileHelper.writeAllObjects(file, manageInspectionSchedulesArrayList);
        manageInspectionSchedulesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageInspectionSchedulesArrayList);
    }

    @javafx.fxml.FXML
    public void deleteOnAction(ActionEvent actionEvent) {
        for (ManageInspectionSchedules cb: manageInspectionSchedulesArrayList){
            if (inspectionID3.getText().equals(cb.getInspectionID())){
                manageInspectionSchedulesArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, manageInspectionSchedulesArrayList);
        manageInspectionSchedulesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageInspectionSchedulesArrayList);
    }

    @javafx.fxml.FXML
    public void signoutOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "shifat/DirectorofBankingRegulation.fxml", "Sign Out");

    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        for (ManageInspectionSchedules cb: manageInspectionSchedulesArrayList){
            if (inspectionID2.getText().equals(cb.getInspectionID())){
                cb.setBankName(bankName2.getText());
                cb.setDate(inspectionDate2.getValue());
                cb.setInspectorName(inspectorName2.getText());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageInspectionSchedulesArrayList);
        manageInspectionSchedulesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageInspectionSchedulesArrayList);
    }
}