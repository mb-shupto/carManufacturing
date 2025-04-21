package Hasibul_2321368;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

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
    private TableView<VehicleMaintenanceRequest> maintenanceRequestTableView;

    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> RequestIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> VehicleIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> IssueDescriptionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> TechnicianAssignTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> VehicleInformationTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, LocalDate> RequestDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, LocalDate> ScheduledDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VehicleMaintenanceRequest, String> TaskStatusTableColumn;

    private ObservableList<VehicleMaintenanceRequest> maintenanceRequestList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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
