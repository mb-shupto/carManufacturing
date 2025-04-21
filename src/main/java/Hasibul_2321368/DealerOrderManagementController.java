package Hasibul_2321368;

import Hasibul_2321368.modelclass.DealerOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

public class DealerOrderManagementController {

    @javafx.fxml.FXML
    private TextField OrderIDTextField;
    @javafx.fxml.FXML
    private TextField DealerNameTextField;
    @javafx.fxml.FXML
    private TextField CarModelTextField;
    @javafx.fxml.FXML
    private DatePicker OrderDateDatePicker;
    @javafx.fxml.FXML
    private RadioButton PendingRadioButton;
    @javafx.fxml.FXML
    private RadioButton RejectedRadioButton;
    @javafx.fxml.FXML
    private RadioButton ApprovedRadioButton;
    @javafx.fxml.FXML
    private TextField QuantityOrderedTextField;
    @javafx.fxml.FXML
    private TextField PricePerUnitTextField;
    @javafx.fxml.FXML
    private DatePicker DeliveryDateDatePicker;
    @javafx.fxml.FXML
    private TextField TotalAmountTextField;
    @javafx.fxml.FXML
    private TableView<DealerOrder> dealerOrderTableView;

    @javafx.fxml.FXML
    private TableColumn<DealerOrder, String> OrderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, String> DealerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, String> CarModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, LocalDate> OrderDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, Integer> QuantityOrderedTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, Double> PricePerUnitTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, String> OrderStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, Double> TotalAmountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DealerOrder, LocalDate> DeliveryDateTableColumn;

    private ObservableList<DealerOrder> dealerOrderList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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
