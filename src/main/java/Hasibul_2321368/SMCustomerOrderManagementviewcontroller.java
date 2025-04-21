package Hasibul_2321368;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

public class SMCustomerOrderManagementviewcontroller {

    @javafx.fxml.FXML
    private TextField OrderIDTextField;
    @javafx.fxml.FXML
    private TextField CustomerNameTextField;
    @javafx.fxml.FXML
    private DatePicker OrderDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> CarModelComboBox;
    @javafx.fxml.FXML
    private RadioButton PendingRadioButton;
    @javafx.fxml.FXML
    private RadioButton DeliveredRadioButton;
    @javafx.fxml.FXML
    private RadioButton ShippedRadioButton;
    @javafx.fxml.FXML
    private TextField TotalAmountTextField;
    @javafx.fxml.FXML
    private RadioButton CompletedRadioButton;
    @javafx.fxml.FXML
    private RadioButton FailedRadioButton;
    @javafx.fxml.FXML
    private RadioButton PaymentPendingRadioButton;
    @javafx.fxml.FXML
    private DatePicker DeliveryDateDatePicker;
    @javafx.fxml.FXML
    private TableView<CustomerOrder> customerOrderTableView;

    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> OrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> CustomerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, Double> TotalAmountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, LocalDate> OrderDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> OrderStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> CarModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, LocalDate> DeliveryDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrder, String> PaymentStatusTableColumn;

    private ObservableList<CustomerOrder> customerOrderList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private void initialize() {
        CarModelComboBox.getItems().addAll("Model A", "Model B", "Model C");

        OrderIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        CustomerNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        TotalAmountTableColumn.setCellValueFactory(cellData -> cellData.getValue().totalAmountProperty().asObject());
        OrderDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderDateProperty());
        OrderStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderStatusProperty());
        CarModelTableColumn.setCellValueFactory(cellData -> cellData.getValue().carModelProperty());
        DeliveryDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().deliveryDateProperty());
        PaymentStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().paymentStatusProperty());

        customerOrderTableView.setItems(customerOrderList);
    }

    @javafx.fxml.FXML
    private void GenerateButtonOnAction(MouseEvent event) {
        // Validate input fields
        if (OrderIDTextField.getText().isEmpty() || CustomerNameTextField.getText().isEmpty() || TotalAmountTextField.getText().isEmpty()) {
            showAlert("Error", "Please fill all the required fields.");
            return;
        }


        String orderID = OrderIDTextField.getText();
        String customerName = CustomerNameTextField.getText();
        LocalDate orderDate = OrderDateDatePicker.getValue();
        double totalAmount = Double.parseDouble(TotalAmountTextField.getText());
        String orderStatus = getOrderStatus();
        String carModel = CarModelComboBox.getValue();
        LocalDate deliveryDate = DeliveryDateDatePicker.getValue();
        String paymentStatus = getPaymentStatus();

        CustomerOrder customerOrder = new CustomerOrder(orderID, customerName, orderDate, totalAmount, orderStatus,
                carModel, deliveryDate, paymentStatus);


        customerOrderList.add(customerOrder);
    }

    private String getOrderStatus() {
        if (PendingRadioButton.isSelected()) {
            return "Pending";
        } else if (ShippedRadioButton.isSelected()) {
            return "Shipped";
        } else if (DeliveredRadioButton.isSelected()) {
            return "Delivered";
        }
        return "Unknown";
    }

    private String getPaymentStatus() {
        if (CompletedRadioButton.isSelected()) {
            return "Completed";
        } else if (PaymentPendingRadioButton.isSelected()) {
            return "Pending";
        } else if (FailedRadioButton.isSelected()) {
            return "Failed";
        }
        return "Unknown";
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}