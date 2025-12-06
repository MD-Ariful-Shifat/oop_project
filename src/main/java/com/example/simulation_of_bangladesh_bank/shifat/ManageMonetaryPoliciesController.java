package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageMonetaryPoliciesController
{
    @javafx.fxml.FXML
    private TextField policyID1;
    @javafx.fxml.FXML
    private TextField policyName1;
    @javafx.fxml.FXML
    private ComboBox<String> StatusID2;
    @javafx.fxml.FXML
    private ComboBox<String> StatusID1;
    @javafx.fxml.FXML
    private TextField policyName2;
    @javafx.fxml.FXML
    private TextField policyID2;
    @javafx.fxml.FXML
    private TextField dateOfImplementation2;
    @javafx.fxml.FXML
    private TableColumn<ManageMonetaryPolicies, String> policyName3;
    @javafx.fxml.FXML
    private TextField policyID3;
    @javafx.fxml.FXML
    private TableColumn<ManageMonetaryPolicies, String> dateOfImplementation3;
    @javafx.fxml.FXML
    private TextField descriptionID2;
    @javafx.fxml.FXML
    private TextField descriptionID1;
    @javafx.fxml.FXML
    private TableView<ManageMonetaryPolicies> tableview;
    @javafx.fxml.FXML
    private TableColumn<ManageMonetaryPolicies, String> statusID3;
    @javafx.fxml.FXML
    private TableColumn<ManageMonetaryPolicies, String> policyColumn;
    private List<ManageMonetaryPolicies> manageMonetaryPoliciesArrayList = new ArrayList<>();
    private File file = new File( "data/ManageMonetaryPolicies.bin");
    @javafx.fxml.FXML
    private DatePicker dateOfImplementation1;

    @javafx.fxml.FXML
    public void initialize() {
        policyColumn.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        policyName3.setCellValueFactory(new PropertyValueFactory<>("policyName"));
        dateOfImplementation3.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusID3.setCellValueFactory(new PropertyValueFactory<>("status"));

        manageMonetaryPoliciesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageMonetaryPoliciesArrayList);
    }

    @javafx.fxml.FXML
    public void signoutOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "shifat/GovernorDash.fxml", "Sign Out");

    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        for (ManageMonetaryPolicies cb: manageMonetaryPoliciesArrayList){
            if (policyID2.getText().equals(cb.getPolicyId())){
                cb.setPolicyName(policyName2.getText());
                cb.setDescription(descriptionID2.getText());
                cb.setStatus(StatusID2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageMonetaryPoliciesArrayList);
        initialize();
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        ManageMonetaryPolicies manageMonetaryPolicies = new ManageMonetaryPolicies(
                policyID1.getText(),
                policyName1.getText(),
                descriptionID1.getText(),
                dateOfImplementation1.getValue(),
                StatusID1.getValue()


        );

        manageMonetaryPoliciesArrayList.add(manageMonetaryPolicies);
        BinaryFileHelper.writeAllObjects(file, manageMonetaryPoliciesArrayList);
        manageMonetaryPoliciesArrayList = BinaryFileHelper.readAllObjects(file);
        tableview.getItems().clear();
        tableview.getItems().addAll(manageMonetaryPoliciesArrayList);
    }

    @javafx.fxml.FXML
    public void deleteOnAction(ActionEvent actionEvent) {
        for (ManageMonetaryPolicies cb: manageMonetaryPoliciesArrayList){
            if (policyID3.getText().equals(cb.getPolicyId())){
                manageMonetaryPoliciesArrayList.remove(cb);
                break;
            }

        }
    }
}