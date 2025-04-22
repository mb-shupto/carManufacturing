package Hasibul_2321368;

import Hasibul_2321368.modelclass.CustomerOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SMCustomerOrderManagementViewController {

    @javafx.fxml.FXML
    private TextField OrderIDTextField;
    @javafx.fxml.FXML
    private TextField CustomerNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> CarModelComboBox;
    @javafx.fxml.FXML
    private DatePicker OrderDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker DeliveryDateDatePicker;
    @javafx.fxml.FXML
    private TextField TotalAmountTextField;
    @javafx.fxml.FXML
    private RadioButton PendingRadioButton;
    @javafx.fxml.FXML
    private RadioButton DeliveredRadioButton;
    @javafx.fxml.FXML
    private RadioButton ShippedRadioButton;
    @javafx.fxml.FXML
    private RadioButton CompletedRadioButton;
    @javafx.fxml.FXML
    private RadioButton FailedRadioButton;
    @javafx.fxml.FXML
    private RadioButton PendingPaymentRadioButton;

    @javafx.fxml.FXML
    private TableView<CustomerOrder> orderTableView;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> OrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> CustomerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> TotalAmountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> OrderDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> OrderStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> CarModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> DeliveryDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> PaymentStatusTableColumn;

    // Observable list for storing customer orders
    private ObservableList<CustomerOrder> orderList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize ComboBox with car models
        CarModelComboBox.getItems().addAll("Model A", "Model B", "Model C", "Model D");

        // Set up TableView columns with appropriate cell value factories
        OrderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        CustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        TotalAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        OrderDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        OrderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        CarModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        DeliveryDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        PaymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        // Populate the TableView with the data
        orderTableView.setItems(orderList);
    }

    @javafx.fxml.FXML
    private void GenerateButtonOnAction() {
        // Get values from the input fields
        String orderID = OrderIDTextField.getText();
        String customerName = CustomerNameTextField.getText();
        String carModel = CarModelComboBox.getValue();
        String orderStatus = PendingRadioButton.isSelected() ? "Pending" : DeliveredRadioButton.isSelected() ? "Delivered" : "Shipped";
        String totalAmount = TotalAmountTextField.getText();
        String paymentStatus = CompletedRadioButton.isSelected() ? "Completed" : FailedRadioButton.isSelected() ? "Failed" : "Pending";
        String orderDate = OrderDateDatePicker.getValue() != null ? OrderDateDatePicker.getValue().toString() : "";
        String deliveryDate = DeliveryDateDatePicker.getValue() != null ? DeliveryDateDatePicker.getValue().toString() : "";

        // Create a new CustomerOrder object with the input data
        CustomerOrder newOrder = new CustomerOrder(orderID, customerName, carModel, orderStatus, totalAmount, paymentStatus, deliveryDate, orderDate);

        // Add the new order to the orderList
        orderList.add(newOrder);

        // Clear the input fields
        OrderIDTextField.clear();
        CustomerNameTextField.clear();
        CarModelComboBox.setValue(null);
        TotalAmountTextField.clear();
        OrderDateDatePicker.setValue(null);
        DeliveryDateDatePicker.setValue(null);
        PendingRadioButton.setSelected(false);
        DeliveredRadioButton.setSelected(false);
        ShippedRadioButton.setSelected(false);
        CompletedRadioButton.setSelected(false);
        FailedRadioButton.setSelected(false);
        PendingPaymentRadioButton.setSelected(false);
    }
}
