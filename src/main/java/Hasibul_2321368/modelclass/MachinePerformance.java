package Hasibul_2321368.modelclass;

public class MachinePerformance {
    private String machineID;
    private String machineStatus;
    private String lastMaintenanceDate;
    private String nextMaintenanceDue;
    private String machineDetails;
    private String healthScore;
    private String technicianAssigned;
    private String maintenanceTaskStatus;

    public MachinePerformance() {
    }

    public MachinePerformance(String machineID, String machineStatus, String lastMaintenanceDate, String nextMaintenanceDue, String machineDetails, String healthScore, String technicianAssigned, String maintenanceTaskStatus) {
        this.machineID = machineID;
        this.machineStatus = machineStatus;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.nextMaintenanceDue = nextMaintenanceDue;
        this.machineDetails = machineDetails;
        this.healthScore = healthScore;
        this.technicianAssigned = technicianAssigned;
        this.maintenanceTaskStatus = maintenanceTaskStatus;
    }

    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public String getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(String lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getNextMaintenanceDue() {
        return nextMaintenanceDue;
    }

    public void setNextMaintenanceDue(String nextMaintenanceDue) {
        this.nextMaintenanceDue = nextMaintenanceDue;
    }

    public String getMachineDetails() {
        return machineDetails;
    }

    public void setMachineDetails(String machineDetails) {
        this.machineDetails = machineDetails;
    }

    public String getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(String healthScore) {
        this.healthScore = healthScore;
    }

    public String getTechnicianAssigned() {
        return technicianAssigned;
    }

    public void setTechnicianAssigned(String technicianAssigned) {
        this.technicianAssigned = technicianAssigned;
    }

    public String getMaintenanceTaskStatus() {
        return maintenanceTaskStatus;
    }

    public void setMaintenanceTaskStatus(String maintenanceTaskStatus) {
        this.maintenanceTaskStatus = maintenanceTaskStatus;
    }

    @Override
    public String toString() {
        return "MachinePerformance{" +
                "machineID='" + machineID + '\'' +
                ", machineStatus='" + machineStatus + '\'' +
                ", lastMaintenanceDate='" + lastMaintenanceDate + '\'' +
                ", nextMaintenanceDue='" + nextMaintenanceDue + '\'' +
                ", machineDetails='" + machineDetails + '\'' +
                ", healthScore='" + healthScore + '\'' +
                ", technicianAssigned='" + technicianAssigned + '\'' +
                ", maintenanceTaskStatus='" + maintenanceTaskStatus + '\'' +
                '}';
    }
}
