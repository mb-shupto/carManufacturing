package Hasibul_2321368;

import javafx.beans.property.*;
import java.time.LocalDate;

public class CustomerOrder {

    private final SimpleStringProperty orderID;
    private final SimpleStringProperty customerName;
    private final SimpleObjectProperty<LocalDate> orderDate;
    private final SimpleDoubleProperty totalAmount;
    private final SimpleStringProperty orderStatus;
    private final SimpleStringProperty carModel;
    private final SimpleObjectProperty<LocalDate> deliveryDate;
    private final SimpleStringProperty paymentStatus;

    public CustomerOrder(String orderID, String customerName, LocalDate orderDate, double totalAmount,
                         String orderStatus, String carModel, LocalDate deliveryDate, String paymentStatus) {
        this.orderID = new SimpleStringProperty(orderID);
        this.customerName = new SimpleStringProperty(customerName);
        this.orderDate = new SimpleObjectProperty<>(orderDate);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.orderStatus = new SimpleStringProperty(orderStatus);
        this.carModel = new SimpleStringProperty(carModel);
        this.deliveryDate = new SimpleObjectProperty<>(deliveryDate);
        this.paymentStatus = new SimpleStringProperty(paymentStatus);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public LocalDate getOrderDate() {
        return orderDate.get();
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate.set(orderDate);
    }

    public double getTotalAmount() {
        return totalAmount.get();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public String getOrderStatus() {
        return orderStatus.get();
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus.set(orderStatus);
    }

    public String getCarModel() {
        return carModel.get();
    }

    public void setCarModel(String carModel) {
        this.carModel.set(carModel);
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate.get();
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate.set(deliveryDate);
    }

    public String getPaymentStatus() {
        return paymentStatus.get();
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus.set(paymentStatus);
    }

    public SimpleStringProperty orderIDProperty() {
        return orderID;
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public SimpleObjectProperty<LocalDate> orderDateProperty() {
        return orderDate;
    }

    public SimpleDoubleProperty totalAmountProperty() {
        return totalAmount;
    }

    public SimpleStringProperty orderStatusProperty() {
        return orderStatus;
    }

    public SimpleStringProperty carModelProperty() {
        return carModel;
    }

    public SimpleObjectProperty<LocalDate> deliveryDateProperty() {
        return deliveryDate;
    }

    public SimpleStringProperty paymentStatusProperty() {
        return paymentStatus;
    }
}
