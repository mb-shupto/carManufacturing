package Hasibul_2321368;

import Hasibul_2321368.modelclass.CustomerOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SMCustomerOrderManagementViewController {

    @FXML private TextField OrderIDTextField;
    @FXML private TextField CustomerNameTextField;
    @FXML private ComboBox<String> CarModelComboBox;
    @FXML private DatePicker OrderDateDatePicker;
    @FXML private DatePicker DeliveryDateDatePicker;
    @FXML private TextField TotalAmountTextField;
    @FXML private RadioButton PendingRadioButton;
    @FXML private RadioButton DeliveredRadioButton;
    @FXML private RadioButton ShippedRadioButton;
    @FXML private RadioButton CompletedRadioButton;
    @FXML private RadioButton FailedRadioButton;
    @FXML private RadioButton PendingPaymentRadioButton;

    @FXML private TableView<CustomerOrder> orderTableView;
    @FXML private TableColumn<CustomerOrder, String> OrderIDTableColumn;
    @FXML private TableColumn<CustomerOrder, String> CustomerNameTableColumn;
    @FXML private TableColumn<CustomerOrder, String> TotalAmountTableColumn;
    @FXML private TableColumn<CustomerOrder, String> OrderDateTableColumn;
    @FXML private TableColumn<CustomerOrder, String> OrderStatusTableColumn;
    @FXML private TableColumn<CustomerOrder, String> CarModelTableColumn;
    @FXML private TableColumn<CustomerOrder, String> DeliveryDateTableColumn;
    @FXML private TableColumn<CustomerOrder, String> PaymentStatusTableColumn;

    // Observable list for storing customer orders
    private ObservableList<CustomerOrder> orderList = FXCollections.observableArrayList();

    @FXML
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

    @FXML
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
