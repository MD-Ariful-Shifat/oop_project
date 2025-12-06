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

public class VerifyRegulatoryComplianceController
{
    @javafx.fxml.FXML
    private TableColumn<VerifyRegulatoryCompliance, String> titleColumn;
    @javafx.fxml.FXML
    private TextField regulationID;
    @javafx.fxml.FXML
    private TableView<VerifyRegulatoryCompliance> tableID;
    @javafx.fxml.FXML
    private TableColumn<VerifyRegulatoryCompliance, String> dateColumn;
    @javafx.fxml.FXML
    private DatePicker effectiveDate2;
    @javafx.fxml.FXML
    private TextField regulationID3;
    @javafx.fxml.FXML
    private DatePicker effectiveDate;
    @javafx.fxml.FXML
    private TextField regulationID2;
    @javafx.fxml.FXML
    private TableColumn<VerifyRegulatoryCompliance, String> idColumn;
    @javafx.fxml.FXML
    private TextField titleId;
    private List<VerifyRegulatoryCompliance> verifyRegulatoryComplianceListArrayList = new ArrayList<>();
    private File file = new File( "data/VerifyRegulatoryCompliance.bin");

    @javafx.fxml.FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>( "regulationId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>( "regulationTitle"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>( "effectiveDate"));


        verifyRegulatoryComplianceListArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(verifyRegulatoryComplianceListArrayList);
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        VerifyRegulatoryCompliance verifyRegulatoryCompliance = new VerifyRegulatoryCompliance(
                regulationID.getText(),
                titleId.getText(),
                effectiveDate.getValue()


        );

        verifyRegulatoryComplianceListArrayList.add(verifyRegulatoryCompliance);
        BinaryFileHelper.writeAllObjects(file, verifyRegulatoryComplianceListArrayList);
        verifyRegulatoryComplianceListArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(verifyRegulatoryComplianceListArrayList);
    }

    @javafx.fxml.FXML
    public void deleteOnAction(ActionEvent actionEvent) {
        for (VerifyRegulatoryCompliance cb: verifyRegulatoryComplianceListArrayList){
            if (regulationID3.getText().equals(cb.getRegulationId())){
                verifyRegulatoryComplianceListArrayList.remove(cb);
                break;
            }

        }
        BinaryFileHelper.writeAllObjects(file, verifyRegulatoryComplianceListArrayList);
        verifyRegulatoryComplianceListArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(verifyRegulatoryComplianceListArrayList);
    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        for (VerifyRegulatoryCompliance cb: verifyRegulatoryComplianceListArrayList){
            if (regulationID2.getText().equals(cb.getRegulationTitle())){
                cb.setEffectiveDate(effectiveDate2.getValue());
                break;
            }
        }
        BinaryFileHelper.writeAllObjects(file, verifyRegulatoryComplianceListArrayList);
        verifyRegulatoryComplianceListArrayList = BinaryFileHelper.readAllObjects(file);
        tableID.getItems().clear();
        tableID.getItems().addAll(verifyRegulatoryComplianceListArrayList);
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");

    }
}