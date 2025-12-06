package com.example.simulation_of_bangladesh_bank.shifat;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCircularsForBanksController
{
    @javafx.fxml.FXML
    private TableColumn<ManageCircularsForBanks, String> issueDateColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageCircularsForBanks, String> circularColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageCircularsForBanks, String> expireDateColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageCircularsForBanks, String> titleColumn;
    @javafx.fxml.FXML
    private TableColumn<ManageCircularsForBanks, String> statusColumn;
    @javafx.fxml.FXML
    private TextField circularID2;
    @javafx.fxml.FXML
    private TextField titleID2;
    @javafx.fxml.FXML
    private TextField titleID1;
    @javafx.fxml.FXML
    private TextField circularID3;
    @javafx.fxml.FXML
    private TableView<ManageCircularsForBanks> tableID;
    @javafx.fxml.FXML
    private TextField circularID1;
    @javafx.fxml.FXML
    private DatePicker expireDate;
    @javafx.fxml.FXML
    private DatePicker issueDate;
    @javafx.fxml.FXML
    private ComboBox<String> statusID1;
    @javafx.fxml.FXML
    private ComboBox<String> statusID2;
    private List<ManageCircularsForBanks> manageCircularsForBanksArrayList = new ArrayList<>();
    private File file = new File( "data/ManageCircularsForBanks.bin");


    @javafx.fxml.FXML
    public void initialize() {

        circularColumn.setCellValueFactory(new PropertyValueFactory<>("circularID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        expireDateColumn.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        manageCircularsForBanksArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageCircularsForBanksArrayList);
    }

    @javafx.fxml.FXML
    public void publishOnClick(ActionEvent actionEvent) {
        ManageCircularsForBanks manageCircularsForBanks = new ManageCircularsForBanks(
                circularID1.getText(),
                titleID1.getText(),
                issueDate.getValue(),
                expireDate.getValue(),
                statusID1.getValue()


        );

        manageCircularsForBanksArrayList.add(manageCircularsForBanks);
        BinaryFileHelper.writeAllObjects(file, manageCircularsForBanksArrayList);
        manageCircularsForBanksArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageCircularsForBanksArrayList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (ManageCircularsForBanks cb: manageCircularsForBanksArrayList){
            if (circularID3.getText().equals(cb.getCircularID())){
                manageCircularsForBanksArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, manageCircularsForBanksArrayList);
        manageCircularsForBanksArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageCircularsForBanksArrayList);
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (ManageCircularsForBanks cb: manageCircularsForBanksArrayList){
            if (circularID2.getText().equals(cb.getCircularID())){
                cb.setTitle(titleID2.getText());
                cb.setStatus(statusID2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, manageCircularsForBanksArrayList);
        manageCircularsForBanksArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(manageCircularsForBanksArrayList);

    }
}