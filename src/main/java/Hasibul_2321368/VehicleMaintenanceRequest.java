package Hasibul_2321368;

import javafx.beans.property.*;
import java.time.LocalDate;

public class VehicleMaintenanceRequest {

    private final SimpleStringProperty requestID;
    private final SimpleStringProperty vehicleID;
    private final SimpleStringProperty issueDescription;
    private final SimpleStringProperty technicianAssigned;
    private final SimpleStringProperty vehicleInformation;
    private final SimpleObjectProperty<LocalDate> requestDate;
    private final SimpleObjectProperty<LocalDate> scheduledDate;
    private final SimpleStringProperty taskStatus;
    private final SimpleBooleanProperty sparePartsVerification;

    public VehicleMaintenanceRequest(String requestID, String vehicleID, String issueDescription, String technicianAssigned,
                                     String vehicleInformation, LocalDate requestDate, LocalDate scheduledDate,
                                     String taskStatus, boolean sparePartsVerification) {
        this.requestID = new SimpleStringProperty(requestID);
        this.vehicleID = new SimpleStringProperty(vehicleID);
        this.issueDescription = new SimpleStringProperty(issueDescription);
        this.technicianAssigned = new SimpleStringProperty(technicianAssigned);
        this.vehicleInformation = new SimpleStringProperty(vehicleInformation);
        this.requestDate = new SimpleObjectProperty<>(requestDate);
        this.scheduledDate = new SimpleObjectProperty<>(scheduledDate);
        this.taskStatus = new SimpleStringProperty(taskStatus);
        this.sparePartsVerification = new SimpleBooleanProperty(sparePartsVerification);
    }

    public String getRequestID() {
        return requestID.get();
    }

    public void setRequestID(String requestID) {
        this.requestID.set(requestID);
    }

    public String getVehicleID() {
        return vehicleID.get();
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID.set(vehicleID);
    }

    public String getIssueDescription() {
        return issueDescription.get();
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription.set(issueDescription);
    }

    public String getTechnicianAssigned() {
        return technicianAssigned.get();
    }

    public void setTechnicianAssigned(String technicianAssigned) {
        this.technicianAssigned.set(technicianAssigned);
    }

    public String getVehicleInformation() {
        return vehicleInformation.get();
    }

    public void setVehicleInformation(String vehicleInformation) {
        this.vehicleInformation.set(vehicleInformation);
    }

    public LocalDate getRequestDate() {
        return requestDate.get();
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate.set(requestDate);
    }

    public LocalDate getScheduledDate() {
        return scheduledDate.get();
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate.set(scheduledDate);
    }

    public String getTaskStatus() {
        return taskStatus.get();
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus.set(taskStatus);
    }

    public boolean isSparePartsVerification() {
        return sparePartsVerification.get();
    }

    public void setSparePartsVerification(boolean sparePartsVerification) {
        this.sparePartsVerification.set(sparePartsVerification);
    }

    public SimpleStringProperty requestIDProperty() {
        return requestID;
    }

    public SimpleStringProperty vehicleIDProperty() {
        return vehicleID;
    }

    public SimpleStringProperty issueDescriptionProperty() {
        return issueDescription;
    }

    public SimpleStringProperty technicianAssignedProperty() {
        return technicianAssigned;
    }

    public SimpleStringProperty vehicleInformationProperty() {
        return vehicleInformation;
    }

    public SimpleObjectProperty<LocalDate> requestDateProperty() {
        return requestDate;
    }

    public SimpleObjectProperty<LocalDate> scheduledDateProperty() {
        return scheduledDate;
    }

    public SimpleStringProperty taskStatusProperty() {
        return taskStatus;
    }

    public SimpleBooleanProperty sparePartsVerificationProperty() {
        return sparePartsVerification;
    }
}
