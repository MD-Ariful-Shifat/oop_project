package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageStuffInformationController
{
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> positionColumn;
    @javafx.fxml.FXML
    private TextField departmentID;
    @javafx.fxml.FXML
    private TextField nameID1;
    @javafx.fxml.FXML
    private TextField nameID2;
    @javafx.fxml.FXML
    private TextField employeeID3;
    @javafx.fxml.FXML
    private TextField employeeID2;
    @javafx.fxml.FXML
    private TextField employeeID1;
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> nameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> positionID;
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<ManageStaffInformation> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> employeeColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> departmentColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageStaffInformation, String> salaryColumn;
    @javafx.fxml.FXML
    private ComboBox<String> statusID1;
    @javafx.fxml.FXML
    private TextField salaryID;
    @javafx.fxml.FXML
    private ComboBox<String> statusID2;
    private List<ManageStaffInformation> manageStaffInformationArrayList = new ArrayList<>();
    private File file = new File( "data/ManageStaffInformation.bin");

    @javafx.fxml.FXML
    public void initialize() {
        employeeColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        manageStaffInformationArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageStaffInformationArrayList);

    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        ManageStaffInformation manageStaffInformation = new ManageStaffInformation(
                employeeID1.getText(),
                nameID1.getText(),
                departmentID.getText(),
                positionID.getValue(),
                salaryID.getText(),
                statusID1.getValue()


        );

        manageStaffInformationArrayList.add(manageStaffInformation);
        BinaryFileHelper.writeAllObjects(file, manageStaffInformationArrayList);
        manageStaffInformationArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageStaffInformationArrayList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageStaffInformation cb: manageStaffInformationArrayList){
            if (employeeID3.getText().equals(cb.getEmployeeID())){
                manageStaffInformationArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, manageStaffInformationArrayList);
        manageStaffInformationArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageStaffInformationArrayList);
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageStaffInformation cb: manageStaffInformationArrayList){
            if (employeeID2.getText().equals(cb.getEmployeeID())){
                cb.setName(nameID2.getText());
                cb.setStatus(statusID2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageStaffInformationArrayList);
        manageStaffInformationArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageStaffInformationArrayList);
    }
}