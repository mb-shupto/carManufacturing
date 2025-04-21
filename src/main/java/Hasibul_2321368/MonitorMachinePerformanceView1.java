package Hasibul_2321368;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
public class MonitorMachinePerformanceView1 {

    @javafx.fxml.FXML
    private TableView<Machine> machineTableView;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> MachineIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> MachineStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, LocalDate> LastMaintenanceDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, LocalDate> NextMaintenanceDueTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> MachineDetailsTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> ScoreTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> TechnicianAssignTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Machine, String> MaintenanceTaskStatusTableColumn;

    @javafx.fxml.FXML
    private TextField MachineIDTextField;
    @javafx.fxml.FXML
    private TextField MachineStatusTextField;
    @javafx.fxml.FXML
    private DatePicker LastMaintenanceDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker NextMaintenanceDueDatePicker;
    @javafx.fxml.FXML
    private RadioButton GoodRadioButton;
    @javafx.fxml.FXML
    private RadioButton FairRadioButton;
    @javafx.fxml.FXML
    private RadioButton PoorRadioButton;
    @javafx.fxml.FXML
    private TextField MachineDetailsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> TechnicianAssignmentComboBox;
    @javafx.fxml.FXML
    private TextField EnterTaskStatusTextField;

    private ObservableList<Machine> machineList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private void initialize() {
        TechnicianAssignmentComboBox.getItems().addAll("Technician A", "Technician B", "Technician C");

        MachineIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().machineIDProperty());
        MachineStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().machineStatusProperty());
        LastMaintenanceDateTableColumn.setCellValueFactory(cellData -> cellData.getValue().lastMaintenanceDateProperty());
        NextMaintenanceDueTableColumn.setCellValueFactory(cellData -> cellData.getValue().nextMaintenanceDueDateProperty());
        MachineDetailsTableColumn.setCellValueFactory(cellData -> cellData.getValue().machineDetailsProperty());
        ScoreTableColumn.setCellValueFactory(cellData -> cellData.getValue().healthScoreProperty());
        TechnicianAssignTableColumn.setCellValueFactory(cellData -> cellData.getValue().technicianAssignedProperty());
        MaintenanceTaskStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().maintenanceTaskStatusProperty());

        machineTableView.setItems(machineList);
    }

    @javafx.fxml.FXML
    private void GenerateButtonOnAction(MouseEvent event) {
        if (MachineIDTextField.getText().isEmpty() || MachineStatusTextField.getText().isEmpty() ||
                MachineDetailsTextField.getText().isEmpty() || EnterTaskStatusTextField.getText().isEmpty()) {
            showAlert("Error", "Please fill all the fields.");
            return;
        }

        String machineID = MachineIDTextField.getText();
        String machineStatus = MachineStatusTextField.getText();
        LocalDate lastMaintenanceDate = LastMaintenanceDateDatePicker.getValue();
        LocalDate nextMaintenanceDueDate = NextMaintenanceDueDatePicker.getValue();
        String machineDetails = MachineDetailsTextField.getText();
        String healthScore = getHealthScore();
        String technicianAssigned = TechnicianAssignmentComboBox.getValue();
        String taskStatus = EnterTaskStatusTextField.getText();

        Machine machine = new Machine(machineID, machineStatus, lastMaintenanceDate, nextMaintenanceDueDate,
                machineDetails, healthScore, technicianAssigned, taskStatus);
        machineList.add(machine);
    }

    private String getHealthScore() {
        if (GoodRadioButton.isSelected()) {
            return "Good";
        } else if (FairRadioButton.isSelected()) {
            return "Fair";
        } else if (PoorRadioButton.isSelected()) {
            return "Poor";
        }
        return "Unknown";
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
