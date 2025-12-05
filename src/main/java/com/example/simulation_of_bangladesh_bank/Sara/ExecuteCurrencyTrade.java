package com.example.simulation_of_bangladesh_bank.Sara;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteCurrencyTrade {

    @javafx.fxml.FXML
    private TableColumn<ExecuteCurrency_Trade, String> currencyTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ExecuteCurrency_Trade, String> amountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ExecuteCurrency_Trade, String> transactionTypeTableColumn;

    @javafx.fxml.FXML
    private RadioButton buyRadioButton;
    @javafx.fxml.FXML
    private RadioButton sellRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup tradeTypeGroup;

    @javafx.fxml.FXML
    private TextField counterPartyTextField;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TextField rateTextField;

    @javafx.fxml.FXML
    private TableView<ExecuteCurrency_Trade> currencyTableView;
    @javafx.fxml.FXML
    private ComboBox<String> currencyPairComboBox;

    private List<ExecuteCurrency_Trade> executeCurrencyTrade = new ArrayList<>();
    private final File file = new File("data/ExecuteCurrency_Trade.bin");

    @javafx.fxml.FXML
    public void initialize() {

        currencyTableColumn.setCellValueFactory(new PropertyValueFactory<>("currencyPairs"));
        transactionTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        executeCurrencyTrade = BinaryFileHelper.readAllObjects(file);
        currencyTableView.getItems().setAll(executeCurrencyTrade);
    }

    @javafx.fxml.FXML
    public void newOrderOnAction(ActionEvent actionEvent) {

        String type = buyRadioButton.isSelected() ? "BUY" : "SELL";

        ExecuteCurrency_Trade trade = new ExecuteCurrency_Trade(
                currencyPairComboBox.getValue(),
                type,
                amountTextField.getText(),
                rateTextField.getText(),
                counterPartyTextField.getText()
        );

        executeCurrencyTrade.add(trade);
        BinaryFileHelper.writeAllObjects(file, executeCurrencyTrade);

        currencyTableView.getItems().add(trade);
    }

    @javafx.fxml.FXML
    public void clearFormOrderOnAction(ActionEvent event) {
        currencyPairComboBox.setValue(null);
        amountTextField.clear();
        rateTextField.clear();
        counterPartyTextField.clear();
        buyRadioButton.setSelected(true);
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitching.sceneSwitch(actionEvent, "Sara/ForeignExchangeDealer_Dash.fxml", "Back");
    }

    // Getter/Setters
    public List<ExecuteCurrency_Trade> getExecuteCurrencyTrade() {
        return executeCurrencyTrade;
    }

    public void setExecuteCurrencyTrade(List<ExecuteCurrency_Trade> executeCurrencyTrade) {
        this.executeCurrencyTrade = executeCurrencyTrade;
    }
}
