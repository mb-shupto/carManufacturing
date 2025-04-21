package Hasibul_2321368.modelclass;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;

public class StockAndPricing {

    private final StringProperty carModel;
    private final IntegerProperty availableStock;
    private final StringProperty stockStatus;
    private final DoubleProperty unitPrice;
    private final DoubleProperty totalAmount;

    // Constructor
    public StockAndPricing(String carModel, int availableStock, String stockStatus, double unitPrice, double totalAmount) {
        this.carModel = new SimpleStringProperty(carModel);
        this.availableStock = new SimpleIntegerProperty(availableStock);
        this.stockStatus = new SimpleStringProperty(stockStatus);
        this.unitPrice = new SimpleDoubleProperty(unitPrice);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
    }

    // Getter and Setter methods
    public String getCarModel() {
        return carModel.get();
    }

    public void setCarModel(String carModel) {
        this.carModel.set(carModel);
    }

    public StringProperty carModelProperty() {
        return carModel;
    }

    public int getAvailableStock() {
        return availableStock.get();
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock.set(availableStock);
    }

    public IntegerProperty availableStockProperty() {
        return availableStock;
    }

    public String getStockStatus() {
        return stockStatus.get();
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus.set(stockStatus);
    }

    public StringProperty stockStatusProperty() {
        return stockStatus;
    }

    public double getUnitPrice() {
        return unitPrice.get();
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice.set(unitPrice);
    }

    public DoubleProperty unitPriceProperty() {
        return unitPrice;
    }

    public double getTotalAmount() {
        return totalAmount.get();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public DoubleProperty totalAmountProperty() {
        return totalAmount;
    }
}
