package Hasibul_2321368;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

public class ScheduleVehicleMaintenanceViewController {

    @FXML private TextField RequestIDTextField;
    @FXML private TextField VehicleIdTextField;
    @FXML private TextField IssueDescriptionTextField;
    @FXML private TextField VehicleInformationTextField;
    @FXML private DatePicker RequestDateDatePicker;
    @FXML private DatePicker ScheduledDateDatePicker;
    @FXML private ComboBox<String> TechnicianAssignedComboBox;
    @FXML private ComboBox<String> TaskStatusComboBox;
    @FXML private CheckBox SparePartsVerificationCheckBox;
    @FXML private TableView<VehicleMaintenanceRequest> maintenanceRequestTableView;

    @FXML private TableColumn<VehicleMaintenanceRequest, String> RequestIDTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, String> VehicleIDTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, String> IssueDescriptionTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, String> TechnicianAssignTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, String> VehicleInformationTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, LocalDate> RequestDateTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, LocalDate> ScheduledDateTableColumn;
    @FXML private TableColumn<VehicleMaintenanceRequest, String> TaskStatusTableColumn;

    private ObservableList<VehicleMaintenanceRequest> maintenanceRequestList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize ComboBoxes with options
        TechnicianAssignedComboBox.getItems().addAll("Ariyen", "Joti", "Asif", "Abir");
        TaskStatusComboBox.getItems().addAll("Scheduled", "In Progress", "Completed");

        // TableView columns setup
        RequestIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().requestIDProperty());
        VehicleIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().vehicleIDProperty());
        IssueDescriptionTableColumn.setCellValueFactory(cellData -> cellData.getValue().issueDescriptionProperty());
        TechnicianAssignTableColumn.setCellValueFactory(cellData -> cellData.getValue().technicianAssignedProperty());
        VehicleInformationTableColumn.setCellValueFactory(cellData -> cellData.getValue().vehicleInformationProperty());
        RequestDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().requestDateProperty());
        ScheduledDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().scheduledDateProperty());
        TaskStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().taskStatusProperty());

        maintenanceRequestTableView.setItems(maintenanceRequestList);
    }

    @FXML
    private void ConfirmButtonOnAction(MouseEvent event) {
        // Validate input fields
        if (RequestIDTextField.getText().isEmpty() || VehicleIdTextField.getText().isEmpty() || IssueDescriptionTextField.getText().isEmpty()) {
            showAlert("Error", "Please fill all the required fields.");
            return;
        }

        // Get input values
        String requestID = RequestIDTextField.getText();
        String vehicleID = VehicleIdTextField.getText();
        String issueDescription = IssueDescriptionTextField.getText();
        String technicianAssigned = TechnicianAssignedComboBox.getValue();
        String vehicleInformation = VehicleInformationTextField.getText();
        LocalDate requestDate = RequestDateDatePicker.getValue();
        LocalDate scheduledDate = ScheduledDateDatePicker.getValue();
        String taskStatus = TaskStatusComboBox.getValue();
        boolean sparePartsVerification = SparePartsVerificationCheckBox.isSelected();

        // Create a new vehicle maintenance request
        VehicleMaintenanceRequest request = new VehicleMaintenanceRequest(requestID, vehicleID, issueDescription, technicianAssigned,
                vehicleInformation, requestDate, scheduledDate, taskStatus, sparePartsVerification);

        // Add the new request to the table
        maintenanceRequestList.add(request);
    }

    @FXML
    private void CancelButtonOnAction(MouseEvent event) {
        // Clear all fields
        RequestIDTextField.clear();
        VehicleIdTextField.clear();
        IssueDescriptionTextField.clear();
        VehicleInformationTextField.clear();
        TechnicianAssignedComboBox.getSelectionModel().clearSelection();
        TaskStatusComboBox.getSelectionModel().clearSelection();
        SparePartsVerificationCheckBox.setSelected(false);
        RequestDateDatePicker.setValue(null);
        ScheduledDateDatePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
