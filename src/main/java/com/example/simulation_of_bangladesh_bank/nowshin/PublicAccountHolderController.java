package com.example.simulation_of_bangladesh_bank.nowshin;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountHolderController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<PublicAccountHolder, String> accountColumn;
    @javafx.fxml.FXML
    private TableColumn<PublicAccountHolder, String> nameColumn;
    @javafx.fxml.FXML
    private TextField accountNum;
    @javafx.fxml.FXML
    private TextField userID2;
    @javafx.fxml.FXML
    private TableView<PublicAccountHolder> tableID;
    @javafx.fxml.FXML
    private TextField nameID;
    @javafx.fxml.FXML
    private TableColumn<PublicAccountHolder, String> dateColumn;
    @javafx.fxml.FXML
    private TextField userID;
    @javafx.fxml.FXML
    private TableColumn<PublicAccountHolder, String> idColumn;
    private List<PublicAccountHolder> publicAccountHolderArrayList = new ArrayList<>();
    private File file = new File( "data/PublicAccountHolder.bin");

    @javafx.fxml.FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>( "regulationId"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>( "regulationTitle"));
        accountColumn.setCellValueFactory(new PropertyValueFactory<>( "effectiveDate"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>( "effectiveDate"));


        publicAccountHolderArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(publicAccountHolderArrayList);
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        tableID.getItems().clear();
        for (PublicAccountHolder cb: publicAccountHolderArrayList) {
            if (userID.getText().equals(cb.getId())) {
                tableID.getItems().add(cb);
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void openOnAction(ActionEvent actionEvent) {
        PublicAccountHolder publicAccountHolder = new PublicAccountHolder(
                nameID.getText(),
                userID.getText(),
                accountNum.getText(),
                date.getValue()


        );

        publicAccountHolderArrayList.add(publicAccountHolder);
        BinaryFileHelper.writeAllObjects(file, publicAccountHolderArrayList);
        publicAccountHolderArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(publicAccountHolderArrayList);
    }
}