package Hasibul_2321368.modelclass;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerComplaint {

    private final StringProperty complaintID;
    private final StringProperty customerName;
    private final StringProperty complaintStatus;
    private final StringProperty assignedDepartment;
    private final StringProperty complaintDescription;
    private final StringProperty complaintDate;
    private final StringProperty resolutionDeadline;
    private final StringProperty priority;

    // Constructor
    public CustomerComplaint(String complaintID, String customerName, String complaintStatus,
                             String assignedDepartment, String complaintDescription,
                             String complaintDate, String resolutionDeadline, String priority) {
        this.complaintID = new SimpleStringProperty(complaintID);
        this.customerName = new SimpleStringProperty(customerName);
        this.complaintStatus = new SimpleStringProperty(complaintStatus);
        this.assignedDepartment = new SimpleStringProperty(assignedDepartment);
        this.complaintDescription = new SimpleStringProperty(complaintDescription);
        this.complaintDate = new SimpleStringProperty(complaintDate);
        this.resolutionDeadline = new SimpleStringProperty(resolutionDeadline);
        this.priority = new SimpleStringProperty(priority);
    }

    // Getter and Setter methods
    public String getComplaintID() {
        return complaintID.get();
    }

    public void setComplaintID(String complaintID) {
        this.complaintID.set(complaintID);
    }

    public StringProperty complaintIDProperty() {
        return complaintID;
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public String getComplaintStatus() {
        return complaintStatus.get();
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus.set(complaintStatus);
    }

    public StringProperty complaintStatusProperty() {
        return complaintStatus;
    }

    public String getAssignedDepartment() {
        return assignedDepartment.get();
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment.set(assignedDepartment);
    }

    public StringProperty assignedDepartmentProperty() {
        return assignedDepartment;
    }

    public String getComplaintDescription() {
        return complaintDescription.get();
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription.set(complaintDescription);
    }

    public StringProperty complaintDescriptionProperty() {
        return complaintDescription;
    }

    public String getComplaintDate() {
        return complaintDate.get();
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate.set(complaintDate);
    }

    public StringProperty complaintDateProperty() {
        return complaintDate;
    }

    public String getResolutionDeadline() {
        return resolutionDeadline.get();
    }

    public void setResolutionDeadline(String resolutionDeadline) {
        this.resolutionDeadline.set(resolutionDeadline);
    }

    public StringProperty resolutionDeadlineProperty() {
        return resolutionDeadline;
    }

    public String getPriority() {
        return priority.get();
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public StringProperty priorityProperty() {
        return priority;
    }
}
