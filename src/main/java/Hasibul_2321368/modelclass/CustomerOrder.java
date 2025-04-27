package Hasibul_2321368.modelclass;

import javafx.beans.property.*;
import java.time.LocalDate;

public class CustomerOrder {

    private String orderID;
    private String customerName;
    private String totalAmount;
    private String orderStatus;
    private String paymentStatus;
    private String carModel;
    private String orderDate;
    private String deliveryDate;

    // Constructors
    public CustomerOrder(String orderID, String customerName, String totalAmount, String orderStatus,
                         String paymentStatus, String carModel, String orderDate, String deliveryDate) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.carModel = carModel;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
