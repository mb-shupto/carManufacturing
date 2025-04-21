package supto_1930875;

import javafx.beans.property.SimpleStringProperty;

public class Bottleneck {
    private final SimpleStringProperty bottleneckName;
    private final SimpleStringProperty status;

    public Bottleneck(String bottleneckName, String status) {
        this.bottleneckName = new SimpleStringProperty(bottleneckName);
        this.status = new SimpleStringProperty(status);
    }

    public String getBottleneckName() {
        return bottleneckName.get();
    }

    public SimpleStringProperty bottleneckNameProperty() {
        return bottleneckName;
    }

    public void setBottleneckName(String bottleneckName) {
        this.bottleneckName.set(bottleneckName);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}