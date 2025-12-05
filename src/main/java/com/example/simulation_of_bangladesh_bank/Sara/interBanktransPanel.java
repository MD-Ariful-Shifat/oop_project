package com.example.simulation_of_bangladesh_bank.Sara;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class interBanktransPanel {
    @javafx.fxml.FXML
    private TextField amount;
    @javafx.fxml.FXML
    private TextField holderNameField;
    @javafx.fxml.FXML
    private TextField accountField;
    @javafx.fxml.FXML
    private Button enterButton;
    @javafx.fxml.FXML
    private Label alertBox;
    @javafx.fxml.FXML
    private ComboBox<String> cardNameCom;
    @javafx.fxml.FXML
    private ComboBox<String> bankNameCom;

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutButton(ActionEvent actionEvent) throws IOException {
        SceneSwitching.sceneSwitch(actionEvent, "saida/fxml/Login.fxml", "Bangladesh Bank - Login");
    }
}
