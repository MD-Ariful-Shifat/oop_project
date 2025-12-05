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

public class SuperviseCommercialBanksController
{
    @javafx.fxml.FXML
    private TableColumn<SuperviseCommercialBanks, Integer> licenseColumn;
    @javafx.fxml.FXML
    private TableColumn<SuperviseCommercialBanks, String> typeColumn;
    @javafx.fxml.FXML
    private TextField nameID2;
    @javafx.fxml.FXML
    private TextField bankId;
    @javafx.fxml.FXML
    private TextField bankId2;
    @javafx.fxml.FXML
    private TableColumn<SuperviseCommercialBanks, String> nameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> statusID;
    @javafx.fxml.FXML
    private TextField bankId3;
    @javafx.fxml.FXML
    private TextField bankId4;
    @javafx.fxml.FXML
    private TableColumn<SuperviseCommercialBanks, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<SuperviseCommercialBanks> tableID;
    @javafx.fxml.FXML
    private TableColumn<SuperviseCommercialBanks, String> bankColumn;
    @javafx.fxml.FXML
    private TextField nameID;
    @javafx.fxml.FXML
    private ComboBox<String> typeID;
    @javafx.fxml.FXML
    private ComboBox<String> typeID2;
    @javafx.fxml.FXML
    private TextField licenseID;
    @javafx.fxml.FXML
    private ComboBox<String> statusID2;
    private List<SuperviseCommercialBanks> superviseCommercialBanksArrayList = new ArrayList<>();
    private File file = new File( "data/SuperviseCommercialBanks.bin");

    @javafx.fxml.FXML
    public void initialize() {
        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bankId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        licenseColumn.setCellValueFactory(new PropertyValueFactory<>("licensenumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        superviseCommercialBanksArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(superviseCommercialBanksArrayList);


    }

    @javafx.fxml.FXML
    public void addOnClicnk(ActionEvent actionEvent) {
        SuperviseCommercialBanks superviseCommercialBanks = new SuperviseCommercialBanks(
                bankId.getText(),
                nameID.getText(),
                Integer.parseInt(licenseID.getText()),
                typeID.getValue(),
                statusID.getValue()

        );

        superviseCommercialBanksArrayList.add(superviseCommercialBanks);
        BinaryFileHelper.writeAllObjects(file, superviseCommercialBanksArrayList);
    }

    @javafx.fxml.FXML
    public void signOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }

    @javafx.fxml.FXML
    public void deleteOnClick(ActionEvent actionEvent) {
        for (SuperviseCommercialBanks cb: superviseCommercialBanksArrayList){
            if (bankId3.getText().equals(cb.getBankId())){
                superviseCommercialBanksArrayList.remove(cb);
                break;
            }

        }
    }

    @javafx.fxml.FXML
    public void searchOnClickk(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateOnClicnk(ActionEvent actionEvent) {
        for (SuperviseCommercialBanks cb: superviseCommercialBanksArrayList){
            if (bankId2.getText().equals(cb.getBankId())){
                cb.setName(nameID2.getText());
                cb.setType(typeID2.getValue());
                cb.setStatus(statusID2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, superviseCommercialBanksArrayList);
        initialize();
    }
}