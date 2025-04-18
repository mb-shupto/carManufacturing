package Hasibul_2321368;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

public class DealerOrderManagementController {

    @FXML private TextField OrderIDTextField;
    @FXML private TextField DealerNameTextField;
    @FXML private TextField CarModelTextField;
    @FXML private DatePicker OrderDateDatePicker;
    @FXML private RadioButton PendingRadioButton;
    @FXML private RadioButton RejectedRadioButton;
    @FXML private RadioButton ApprovedRadioButton;
    @FXML private TextField QuantityOrderedTextField;
    @FXML private TextField PricePerUnitTextField;
    @FXML private DatePicker DeliveryDateDatePicker;
    @FXML private TextField TotalAmountTextField;
    @FXML private TableView<DealerOrder> dealerOrderTableView;

    @FXML private TableColumn<DealerOrder, String> OrderIDTableColumn;
    @FXML private TableColumn<DealerOrder, String> DealerNameTableColumn;
    @FXML private TableColumn<DealerOrder, String> CarModelTableColumn;
    @FXML private TableColumn<DealerOrder, LocalDate> OrderDateTableColumn;
    @FXML private TableColumn<DealerOrder, Integer> QuantityOrderedTableColumn;
    @FXML private TableColumn<DealerOrder, Double> PricePerUnitTableColumn;
    @FXML private TableColumn<DealerOrder, String> OrderStatusTableColumn;
    @FXML private TableColumn<DealerOrder, Double> TotalAmountTableColumn;
    @FXML private TableColumn<DealerOrder, LocalDate> DeliveryDateTableColumn;

    private ObservableList<DealerOrder> dealerOrderList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        OrderIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        DealerNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().dealerNameProperty());
        CarModelTableColumn.setCellValueFactory(cellData -> cellData.getValue().carModelProperty());
        OrderDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderDateProperty());
        QuantityOrderedTableColumn.setCellValueFactory(cellData -> cellData.getValue().quantityOrderedProperty().asObject());
        PricePerUnitTableColumn.setCellValueFactory(cellData -> cellData.getValue().pricePerUnitProperty().asObject());
        OrderStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().orderStatusProperty());
        TotalAmountTableColumn.setCellValueFactory(cellData -> cellData.getValue().totalAmountProperty().asObject());
        DeliveryDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().deliveryDateProperty());

        dealerOrderTableView.setItems(dealerOrderList);
    }

    @FXML
    private void GenerateButtonOnAction(MouseEvent event) {
        if (OrderIDTextField.getText().isEmpty() || DealerNameTextField.getText().isEmpty() || CarModelTextField.getText().isEmpty()) {
            showAlert("Error", "Please fill all the required fields.");
            return;
        }

        String orderID = OrderIDTextField.getText();
        String dealerName = DealerNameTextField.getText();
        String carModel = CarModelTextField.getText();
        LocalDate orderDate = OrderDateDatePicker.getValue();
        int quantityOrdered = Integer.parseInt(QuantityOrderedTextField.getText());
        double pricePerUnit = Double.parseDouble(PricePerUnitTextField.getText());
        String orderStatus = getOrderStatus();
        double totalAmount = quantityOrdered * pricePerUnit;
        LocalDate deliveryDate = DeliveryDateDatePicker.getValue();

        DealerOrder order = new DealerOrder(orderID, dealerName, carModel, orderDate, quantityOrdered, pricePerUnit,
                orderStatus, totalAmount, deliveryDate);

        dealerOrderList.add(order);
    }

    @FXML
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String getOrderStatus() {
        if (PendingRadioButton.isSelected()) {
            return "Pending";
        } else if (RejectedRadioButton.isSelected()) {
            return "Rejected";
        } else if (ApprovedRadioButton.isSelected()) {
            return "Approved";
        }
        return "Unknown";
    }
}
