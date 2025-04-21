package Hasibul_2321368.modelclass;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VehicleMaintenance {

    private final StringProperty requestID;
    private final StringProperty vehicleID;
    private final StringProperty issueDescription;
    private final StringProperty technicianAssigned;
    private final StringProperty vehicleInformation;
    private final StringProperty requestDate;
    private final StringProperty scheduledDate;
    private final StringProperty taskStatus;
    private final SimpleBooleanProperty sparePartsVerification;

    // Constructor
    public VehicleMaintenance(String requestID, String vehicleID, String issueDescription,
                              String technicianAssigned, String vehicleInformation, String requestDate,
                              String scheduledDate, String taskStatus, boolean sparePartsVerification) {
        this.requestID = new SimpleStringProperty(requestID);
        this.vehicleID = new SimpleStringProperty(vehicleID);
        this.issueDescription = new SimpleStringProperty(issueDescription);
        this.technicianAssigned = new SimpleStringProperty(technicianAssigned);
        this.vehicleInformation = new SimpleStringProperty(vehicleInformation);
        this.requestDate = new SimpleStringProperty(requestDate);
        this.scheduledDate = new SimpleStringProperty(scheduledDate);
        this.taskStatus = new SimpleStringProperty(taskStatus);
        this.sparePartsVerification = new SimpleBooleanProperty(sparePartsVerification);
    }

    // Getter and Setter methods
    public String getRequestID() {
        return requestID.get();
    }

    public StringProperty requestIDProperty() {
        return requestID;
    }

    public String getVehicleID() {
        return vehicleID.get();
    }

    public StringProperty vehicleIDProperty() {
        return vehicleID;
    }

    public String getIssueDescription() {
        return issueDescription.get();
    }

    public StringProperty issueDescriptionProperty() {
        return issueDescription;
    }

    public String getTechnicianAssigned() {
        return technicianAssigned.get();
    }

    public StringProperty technicianAssignedProperty() {
        return technicianAssigned;
    }

    public String getVehicleInformation() {
        return vehicleInformation.get();
    }

    public StringProperty vehicleInformationProperty() {
        return vehicleInformation;
    }

    public String getRequestDate() {
        return requestDate.get();
    }

    public StringProperty requestDateProperty() {
        return requestDate;
    }

    public String getScheduledDate() {
        return scheduledDate.get();
    }

    public StringProperty scheduledDateProperty() {
        return scheduledDate;
    }

    public String getTaskStatus() {
        return taskStatus.get();
    }

    public StringProperty taskStatusProperty() {
        return taskStatus;
    }

    public boolean isSparePartsVerification() {
        return sparePartsVerification.get();
    }

    public SimpleBooleanProperty sparePartsVerificationProperty() {
        return sparePartsVerification;
    }
}
