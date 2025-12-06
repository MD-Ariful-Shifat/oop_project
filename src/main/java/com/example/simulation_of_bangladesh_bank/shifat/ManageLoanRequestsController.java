package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageLoanRequestsController
{
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> amountColumn;
    @javafx.fxml.FXML
    private TextField nameID1;
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> loanColumn;
    @javafx.fxml.FXML
    private TextField purposeID1;
    @javafx.fxml.FXML
    private TextField nameID2;
    @javafx.fxml.FXML
    private TextField loanID1;
    @javafx.fxml.FXML
    private TextField amountID1;
    @javafx.fxml.FXML
    private TextField loanID2;
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<ManageLoanRequests> tableID;
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> purposeColumn;
    @javafx.fxml.FXML
    private TextField loanID3;
    @javafx.fxml.FXML
    private TextField loanID4;
    @javafx.fxml.FXML
    private ComboBox<String> statusID1;
    @javafx.fxml.FXML
    private TableColumn<ManageLoanRequests, String> applicationDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> statusID2;
    private List<ManageLoanRequests> manageLoanRequestsArrayList = new ArrayList<>();
    private File file = new File( "data/ManageLoanRequests.bin");
    @javafx.fxml.FXML
    private DatePicker applicationDate1;

    @javafx.fxml.FXML
    public void initialize() {
        loanColumn.setCellValueFactory(new PropertyValueFactory<>("loanId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amountRequested"));
        purposeColumn.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        applicationDateColumn.setCellValueFactory(new PropertyValueFactory<>("applicationDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        manageLoanRequestsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageLoanRequestsArrayList);


    }

    @javafx.fxml.FXML
    public void searchOnClick(ActionEvent actionEvent) {
        tableID.getItems().clear();
        for (ManageLoanRequests cb: manageLoanRequestsArrayList) {
            if (loanID3.getText().equals(cb.getLoanId())) {
                tableID.getItems().add(cb);
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void rejectOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void saveOnClick(ActionEvent actionEvent) {
        ManageLoanRequests manageLoanRequests = new ManageLoanRequests(
                loanID1.getText(),
                nameID1.getText(),
                Integer.parseInt(amountID1.getText()),
                purposeID1.getText(),
                applicationDate1.getValue(),
                statusID1.getValue()


        );

        manageLoanRequestsArrayList.add(manageLoanRequests);
        BinaryFileHelper.writeAllObjects(file, manageLoanRequestsArrayList);
        manageLoanRequestsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageLoanRequestsArrayList);
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageLoanRequests cb: manageLoanRequestsArrayList){
            if (loanID2.getText().equals(cb.getLoanId())){
                cb.setBankName(nameID2.getText());
                cb.setStatus(statusID2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageLoanRequestsArrayList);
        manageLoanRequestsArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageLoanRequestsArrayList);
    }
}