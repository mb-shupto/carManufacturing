package Hasibul_2321368;

import Hasibul_2321368.modelclass.StockAndPricing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class stockandpricingcontroller {

    @javafx.fxml.FXML
    private ComboBox<String> CarModelComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> StockStatusCombobox;
    @javafx.fxml.FXML
    private TextField UnitPriceTextField;
    @javafx.fxml.FXML
    private TextField TotalAmountTextField;
    @javafx.fxml.FXML
    private ComboBox<String> AvailableStockComboBox;

    @javafx.fxml.FXML
    private TableView<StockAndPricing> stockTableView;
    @javafx.fxml.FXML
    private TableColumn<StockAndPricing, String> CarModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StockAndPricing, Integer> AvailableStockTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StockAndPricing, String> StockStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StockAndPricing, Double> UnitPriceTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StockAndPricing, Double> TotalAmountTableColumn;

    @javafx.fxml.FXML
    private Button ApproveOrderButton;
    @javafx.fxml.FXML
    private Button RejectOrderButton;
    @javafx.fxml.FXML
    private Button ConfirmOrderButton;

    // Observable list for storing stock and pricing data
    private ObservableList<StockAndPricing> stockList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Set up TableView columns with appropriate cell value factories
        CarModelTableColumn.setCellValueFactory(cellData -> cellData.getValue().carModelProperty());
        AvailableStockTableColumn.setCellValueFactory(cellData -> cellData.getValue().availableStockProperty().asObject());
        StockStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().stockStatusProperty());
        UnitPriceTableColumn.setCellValueFactory(cellData -> cellData.getValue().unitPriceProperty().asObject());
        TotalAmountTableColumn.setCellValueFactory(cellData -> cellData.getValue().totalAmountProperty().asObject());

        // Set TableView to display the list of stock and pricing data
        stockTableView.setItems(stockList);

        // Initialize ComboBoxes with example data
        CarModelComboBox.getItems().addAll("Model A", "Model B", "Model C");
        StockStatusCombobox.getItems().addAll("In Stock", "Out of Stock");
        AvailableStockComboBox.getItems().addAll("In Stock", "Out of Stock");
    }

    // Approve order button action: Calculate total amount and update stock
    @javafx.fxml.FXML
    private void ApproveOrderButtonOnAction() {
        String carModel = CarModelComboBox.getValue();
        String stockStatus = StockStatusCombobox.getValue();
        int availableStock = Integer.parseInt(AvailableStockComboBox.getValue());
        double unitPrice = Double.parseDouble(UnitPriceTextField.getText());

        double totalAmount = unitPrice * availableStock;

        // Create a new StockAndPricing object and add it to the list
        StockAndPricing newStock = new StockAndPricing(carModel, availableStock, stockStatus, unitPrice, totalAmount);
        stockList.add(newStock);

        // Update the Total Amount field
        TotalAmountTextField.setText(String.valueOf(totalAmount));

        // Clear the input fields
        CarModelComboBox.setValue(null);
        StockStatusCombobox.setValue(null);
        AvailableStockComboBox.setValue(null);
        UnitPriceTextField.clear();
    }

    // Reject order button action: Remove the selected order from the table
    @javafx.fxml.FXML
    private void RejectOrderButtonOnAction(MouseEvent event) {
        StockAndPricing selectedStock = stockTableView.getSelectionModel().getSelectedItem();
        if (selectedStock != null) {
            stockList.remove(selectedStock);
        }
    }

    // Confirm order button action: Confirm the selected order
    @javafx.fxml.FXML
    private void ConfirmOrderButtonOnAction(MouseEvent event) {
        StockAndPricing selectedStock = stockTableView.getSelectionModel().getSelectedItem();
        if (selectedStock != null) {
            // Logic to confirm the order (e.g., update database, notify user, etc.)
            System.out.println("Order Confirmed for: " + selectedStock.getCarModel());
        }
    }
}
