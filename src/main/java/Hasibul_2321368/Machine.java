package Hasibul_2321368;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Machine {

    private final SimpleStringProperty machineID;
    private final SimpleStringProperty machineStatus;
    private final SimpleObjectProperty<LocalDate> lastMaintenanceDate;
    private final SimpleObjectProperty<LocalDate> nextMaintenanceDueDate;
    private final SimpleStringProperty machineDetails;
    private final SimpleStringProperty healthScore;
    private final SimpleStringProperty technicianAssigned;
    private final SimpleStringProperty maintenanceTaskStatus;

    public Machine(String machineID, String machineStatus, LocalDate lastMaintenanceDate, LocalDate nextMaintenanceDueDate,
                   String machineDetails, String healthScore, String technicianAssigned, String maintenanceTaskStatus) {
        this.machineID = new SimpleStringProperty(machineID);
        this.machineStatus = new SimpleStringProperty(machineStatus);
        this.lastMaintenanceDate = new SimpleObjectProperty<>(lastMaintenanceDate);
        this.nextMaintenanceDueDate = new SimpleObjectProperty<>(nextMaintenanceDueDate);
        this.machineDetails = new SimpleStringProperty(machineDetails);
        this.healthScore = new SimpleStringProperty(healthScore);
        this.technicianAssigned = new SimpleStringProperty(technicianAssigned);
        this.maintenanceTaskStatus = new SimpleStringProperty(maintenanceTaskStatus);
    }

    public String getMachineID() {
        return machineID.get();
    }

    public void setMachineID(String machineID) {
        this.machineID.set(machineID);
    }

    public String getMachineStatus() {
        return machineStatus.get();
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus.set(machineStatus);
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate.get();
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate.set(lastMaintenanceDate);
    }

    public LocalDate getNextMaintenanceDueDate() {
        return nextMaintenanceDueDate.get();
    }

    public void setNextMaintenanceDueDate(LocalDate nextMaintenanceDueDate) {
        this.nextMaintenanceDueDate.set(nextMaintenanceDueDate);
    }

    public String getMachineDetails() {
        return machineDetails.get();
    }

    public void setMachineDetails(String machineDetails) {
        this.machineDetails.set(machineDetails);
    }

    public String getHealthScore() {
        return healthScore.get();
    }

    public void setHealthScore(String healthScore) {
        this.healthScore.set(healthScore);
    }

    public String getTechnicianAssigned() {
        return technicianAssigned.get();
    }

    public void setTechnicianAssigned(String technicianAssigned) {
        this.technicianAssigned.set(technicianAssigned);
    }

    public String getMaintenanceTaskStatus() {
        return maintenanceTaskStatus.get();
    }

    public void setMaintenanceTaskStatus(String maintenanceTaskStatus) {
        this.maintenanceTaskStatus.set(maintenanceTaskStatus);
    }

    public SimpleStringProperty machineIDProperty() {
        return machineID;
    }

    public SimpleStringProperty machineStatusProperty() {
        return machineStatus;
    }

    public SimpleObjectProperty<LocalDate> lastMaintenanceDateProperty() {
        return lastMaintenanceDate;
    }

    public SimpleObjectProperty<LocalDate> nextMaintenanceDueDateProperty() {
        return nextMaintenanceDueDate;
    }

    public SimpleStringProperty machineDetailsProperty() {
        return machineDetails;
    }

    public SimpleStringProperty healthScoreProperty() {
        return healthScore;
    }

    public SimpleStringProperty technicianAssignedProperty() {
        return technicianAssigned;
    }

    public SimpleStringProperty maintenanceTaskStatusProperty() {
        return maintenanceTaskStatus;
    }
}
