package Hasibul_2321368;

import Hasibul_2321368.modelclass.VehicleMaintenance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.format.DateTimeFormatter;

public class ScheduleVehicleMaintenanceViewController {

    @javafx.fxml.FXML
    private TextField RequestIDTextField;
    @javafx.fxml.FXML
    private TextField VehicleIdTextField;
    @javafx.fxml.FXML
    private TextField IssueDescriptionTextField;
    @javafx.fxml.FXML
    private TextField VehicleInformationTextField;

    @javafx.fxml.FXML
    private DatePicker RequestDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker ScheduledDateDatePicker;

    @javafx.fxml.FXML
    private ComboBox<String> TechnicianAssignedComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> TaskStatusComboBox;

    @javafx.fxml.FXML
    private CheckBox SparePartsVerificationCheckBox;

    @javafx.fxml.FXML
    private Button ConfirmButton;
    @javafx.fxml.FXML
    private Button CancelButton;

    @javafx.fxml.FXML
    private TableView<VehicleMaintenance> maintenanceTableView;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> RequestIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> VehicleIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> IssueDescriptionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> TechnicianAssignTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> VehicleInformationTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> RequestDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> ScheduledDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenance, String> TaskStatusTableColumn;

    // Observable list for storing vehicle maintenance data
    private ObservableList<VehicleMaintenance> maintenanceList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Set up TableView columns with appropriate cell value factories
        RequestIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().requestIDProperty());
        VehicleIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().vehicleIDProperty());
        IssueDescriptionTableColumn.setCellValueFactory(cellData -> cellData.getValue().issueDescriptionProperty());
        TechnicianAssignTableColumn.setCellValueFactory(cellData -> cellData.getValue().technicianAssignedProperty());
        VehicleInformationTableColumn.setCellValueFactory(cellData -> cellData.getValue().vehicleInformationProperty());
        RequestDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().requestDateProperty());
        ScheduledDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().scheduledDateProperty());
        TaskStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().taskStatusProperty());

        // Set TableView to display the list of vehicle maintenance records
        maintenanceTableView.setItems(maintenanceList);

        // Initialize ComboBox with technician names (example data)
        TechnicianAssignedComboBox.getItems().addAll("Technician A", "Technician B", "Technician C");
        TaskStatusComboBox.getItems().addAll("Scheduled", "In Progress", "Completed");
    }

    // Confirm button action: Add a new vehicle maintenance record
    @javafx.fxml.FXML
    private void ConfirmButtonOnAction() {
        String requestID = RequestIDTextField.getText();
        String vehicleID = VehicleIdTextField.getText();
        String issueDescription = IssueDescriptionTextField.getText();
        String vehicleInformation = VehicleInformationTextField.getText();
        String requestDate = RequestDateDatePicker.getValue() != null ? RequestDateDatePicker.getValue().format(DateTimeFormatter.ISO_DATE) : "";
        String scheduledDate = ScheduledDateDatePicker.getValue() != null ? ScheduledDateDatePicker.getValue().format(DateTimeFormatter.ISO_DATE) : "";
        String technicianAssigned = TechnicianAssignedComboBox.getValue();
        String taskStatus = TaskStatusComboBox.getValue();
        boolean sparePartsVerification = SparePartsVerificationCheckBox.isSelected();

        // Create a new VehicleMaintenance object
        VehicleMaintenance newMaintenanceRequest = new VehicleMaintenance(
                requestID, vehicleID, issueDescription, technicianAssigned, vehicleInformation,
                requestDate, scheduledDate, taskStatus, sparePartsVerification
        );

        // Add the new record to the list
        maintenanceList.add(newMaintenanceRequest);

        // Clear the input fields
        RequestIDTextField.clear();
        VehicleIdTextField.clear();
        IssueDescriptionTextField.clear();
        VehicleInformationTextField.clear();
        RequestDateDatePicker.setValue(null);
        ScheduledDateDatePicker.setValue(null);
        TechnicianAssignedComboBox.setValue(null);
        TaskStatusComboBox.setValue(null);
        SparePartsVerificationCheckBox.setSelected(false);
    }

    // Cancel button action: Clear input fields
    @javafx.fxml.FXML
    private void CancelButtonOnAction() {
        RequestIDTextField.clear();
        VehicleIdTextField.clear();
        IssueDescriptionTextField.clear();
        VehicleInformationTextField.clear();
        RequestDateDatePicker.setValue(null);
        ScheduledDateDatePicker.setValue(null);
        TechnicianAssignedComboBox.setValue(null);
        TaskStatusComboBox.setValue(null);
        SparePartsVerificationCheckBox.setSelected(false);
    }
}
