package Hasibul_2321368;

import javafx.beans.property.*;
import java.time.LocalDate;

public class DealerOrder {

    private final SimpleStringProperty orderID;
    private final SimpleStringProperty dealerName;
    private final SimpleStringProperty carModel;
    private final SimpleObjectProperty<LocalDate> orderDate;
    private final SimpleIntegerProperty quantityOrdered;
    private final SimpleDoubleProperty pricePerUnit;
    private final SimpleStringProperty orderStatus;
    private final SimpleDoubleProperty totalAmount;
    private final SimpleObjectProperty<LocalDate> deliveryDate;

    public DealerOrder(String orderID, String dealerName, String carModel, LocalDate orderDate, int quantityOrdered,
                       double pricePerUnit, String orderStatus, double totalAmount, LocalDate deliveryDate) {
        this.orderID = new SimpleStringProperty(orderID);
        this.dealerName = new SimpleStringProperty(dealerName);
        this.carModel = new SimpleStringProperty(carModel);
        this.orderDate = new SimpleObjectProperty<>(orderDate);
        this.quantityOrdered = new SimpleIntegerProperty(quantityOrdered);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
        this.orderStatus = new SimpleStringProperty(orderStatus);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.deliveryDate = new SimpleObjectProperty<>(deliveryDate);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public String getDealerName() {
        return dealerName.get();
    }

    public void setDealerName(String dealerName) {
        this.dealerName.set(dealerName);
    }

    public String getCarModel() {
        return carModel.get();
    }

    public void setCarModel(String carModel) {
        this.carModel.set(carModel);
    }

    public LocalDate getOrderDate() {
        return orderDate.get();
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate.set(orderDate);
    }

    public int getQuantityOrdered() {
        return quantityOrdered.get();
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered.set(quantityOrdered);
    }

    public double getPricePerUnit() {
        return pricePerUnit.get();
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public String getOrderStatus() {
        return orderStatus.get();
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus.set(orderStatus);
    }

    public double getTotalAmount() {
        return totalAmount.get();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate.get();
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate.set(deliveryDate);
    }

    // Property Getters
    public SimpleStringProperty orderIDProperty() {
        return orderID;
    }

    public SimpleStringProperty dealerNameProperty() {
        return dealerName;
    }

    public SimpleStringProperty carModelProperty() {
        return carModel;
    }

    public SimpleObjectProperty<LocalDate> orderDateProperty() {
        return orderDate;
    }

    public SimpleIntegerProperty quantityOrderedProperty() {
        return quantityOrdered;
    }

    public SimpleDoubleProperty pricePerUnitProperty() {
        return pricePerUnit;
    }

    public SimpleStringProperty orderStatusProperty() {
        return orderStatus;
    }

    public SimpleDoubleProperty totalAmountProperty() {
        return totalAmount;
    }

    public SimpleObjectProperty<LocalDate> deliveryDateProperty() {
        return deliveryDate;
    }
}
