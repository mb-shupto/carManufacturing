package Hasibul_2321368;

import Hasibul_2321368.modelclass.CustomerOrder;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SMCustomerOrderManagementviewcontroller {

    // FXML components from the form
    @FXML private TextField OrderIDTextField;
    @FXML private TextField CustomerNameTextField;
    @FXML private TextField TotalAmountTextField;
    @FXML private ComboBox<String> CarModelComboBox;
    @FXML private DatePicker OrderDateDatePicker;
    @FXML private DatePicker DeliveryDateDatePicker;
    @FXML private RadioButton PendingRadioButton;
    @FXML private RadioButton DeliveredRadioButton;
    @FXML private RadioButton ShippedRadioButton;
    @FXML private RadioButton CompletedRadioButton;
    @FXML private RadioButton FailedRadioButton;
    @FXML private RadioButton PendingPaymentRadioButton;
    @FXML private TableView<CustomerOrder> tableView;
    @FXML private TableColumn<CustomerOrder, String> OrderIDTableColumn;
    @FXML private TableColumn<CustomerOrder, String> CustomerNameTableColumn;
    @FXML private TableColumn<CustomerOrder, String> TotalAmountTableColumn;
    @FXML private TableColumn<CustomerOrder, String> OrderDateTableColumn;
    @FXML private TableColumn<CustomerOrder, String> OrderStatusTableColumn;
    @FXML private TableColumn<CustomerOrder, String> CarModelTableColumn;
    @FXML private TableColumn<CustomerOrder, String> DeliveryDateTableColumn;
    @FXML private TableColumn<CustomerOrder, String> PaymentStatusTableColumn;

    private ToggleGroup orderStatusGroup = new ToggleGroup();
    private ToggleGroup paymentStatusGroup = new ToggleGroup();

    // Initialize method to set up ComboBox and RadioButtons
    @FXML
    public void initialize() {
        // Populate ComboBox for Car Models
        CarModelComboBox.getItems().addAll("Model A", "Model B", "Model C");

        // Set ToggleGroups for RadioButtons
        PendingRadioButton.setToggleGroup(orderStatusGroup);
        DeliveredRadioButton.setToggleGroup(orderStatusGroup);
        ShippedRadioButton.setToggleGroup(orderStatusGroup);

        CompletedRadioButton.setToggleGroup(paymentStatusGroup);
        FailedRadioButton.setToggleGroup(paymentStatusGroup);
        PendingPaymentRadioButton.setToggleGroup(paymentStatusGroup);
    }

    // Handle the Generate button action
    @FXML
    public void GenerateButtonOnAction(MouseEvent event) {
        // Get values from the form fields
        String orderID = OrderIDTextField.getText();
        String customerName = CustomerNameTextField.getText();
        String totalAmount = TotalAmountTextField.getText();
        String carModel = CarModelComboBox.getValue();
        String orderDate = OrderDateDatePicker.getValue().toString();
        String deliveryDate = DeliveryDateDatePicker.getValue().toString();
        String orderStatus = getSelectedOrderStatus();
        String paymentStatus = getSelectedPaymentStatus();

        // Create a new CustomerOrder object and add to TableView
        CustomerOrder newOrder = new CustomerOrder(orderID, customerName, totalAmount, orderStatus, paymentStatus, carModel, orderDate, deliveryDate);
        tableView.getItems().add(newOrder);
    }

    // Helper method to get selected Order Status
    private String getSelectedOrderStatus() {
        if (PendingRadioButton.isSelected()) {
            return "Pending";
        } else if (DeliveredRadioButton.isSelected()) {
            return "Delivered";
        } else {
            return "Shipped";
        }
    }

    // Helper method to get selected Payment Status
    private String getSelectedPaymentStatus() {
        if (CompletedRadioButton.isSelected()) {
            return "Completed";
        } else if (FailedRadioButton.isSelected()) {
            return "Failed";
        } else {
            return "Pending";
        }
    }
}
