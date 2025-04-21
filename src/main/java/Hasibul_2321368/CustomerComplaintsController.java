package Hasibul_2321368;

import Hasibul_2321368.modelclass.CustomerComplaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.time.format.DateTimeFormatter;

public class CustomerComplaintsController {

    @FXML private TextField ComplaintIDTextField;
    @FXML private TextField CustomerNameTextField;
    @FXML private TextField ComplaintDescriptionTextField;
    @FXML private ComboBox<String> ComplaintStatusComboBox;
    @FXML private ComboBox<String> AssignedDepartmentComboBox;
    @FXML private ComboBox<String> PriorityComboBox;
    @FXML private DatePicker ComplaintDateDatePicker;
    @FXML private DatePicker ResolutionDeadlineDatePicker;

    @FXML private TableView<CustomerComplaint> complaintTableView;
    @FXML private TableColumn<CustomerComplaint, String> ComplaintIDTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> CustomerNameTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> ComplaintStatusTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> AssignedDepartmentTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> ComplaintDescriptionTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> ComplaintDatetableColumn;
    @FXML private TableColumn<CustomerComplaint, String> ResolutionDeadlineTableColumn;
    @FXML private TableColumn<CustomerComplaint, String> PriorityTableColumn;

    // Observable list for storing customer complaints
    private ObservableList<CustomerComplaint> complaintList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize ComboBoxes
        ComplaintStatusComboBox.getItems().addAll("Pending", "Resolved", "In Progress");
        AssignedDepartmentComboBox.getItems().addAll("Customer Service", "Tech Support", "Sales");
        PriorityComboBox.getItems().addAll("Low", "Medium", "High");

        // Set up TableView columns

        ComplaintIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().complaintIDProperty());
        ComplaintIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().complaintIDProperty());
        CustomerNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        ComplaintStatusTableColumn.setCellValueFactory(cellData -> cellData.getValue().complaintStatusProperty());
        AssignedDepartmentTableColumn.setCellValueFactory(cellData -> cellData.getValue().assignedDepartmentProperty());
        ComplaintDescriptionTableColumn.setCellValueFactory(cellData -> cellData.getValue().complaintDescriptionProperty());
        ComplaintDatetableColumn.setCellValueFactory(cellData -> cellData.getValue().complaintDateProperty());
        ResolutionDeadlineTableColumn.setCellValueFactory(cellData -> cellData.getValue().resolutionDeadlineProperty());
        PriorityTableColumn.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());

        // Set TableView to display complaint list
        complaintTableView.setItems(complaintList);
    }

    // Confirm button action: Add a new complaint to the table
    @FXML
    private void ConfirmButtonOnAction() {
        String complaintID = ComplaintIDTextField.getText();
        String customerName = CustomerNameTextField.getText();
        String complaintStatus = ComplaintStatusComboBox.getValue();
        String assignedDepartment = AssignedDepartmentComboBox.getValue();
        String complaintDescription = ComplaintDescriptionTextField.getText();
        String complaintDate = ComplaintDateDatePicker.getValue() != null ?
                ComplaintDateDatePicker.getValue().format(DateTimeFormatter.ISO_DATE) : "";
        String resolutionDeadline = ResolutionDeadlineDatePicker.getValue() != null ?
                ResolutionDeadlineDatePicker.getValue().format(DateTimeFormatter.ISO_DATE) : "";
        String priority = PriorityComboBox.getValue();

        // Create new customer complaint object
        CustomerComplaint newComplaint = new CustomerComplaint(complaintID, customerName, complaintStatus,
                assignedDepartment, complaintDescription,
                complaintDate, resolutionDeadline, priority);

        // Add the complaint to the list
        complaintList.add(newComplaint);

        // Clear input fields
        ComplaintIDTextField.clear();
        CustomerNameTextField.clear();
        ComplaintDescriptionTextField.clear();
        ComplaintStatusComboBox.setValue(null);
        AssignedDepartmentComboBox.setValue(null);
        PriorityComboBox.setValue(null);
        ComplaintDateDatePicker.setValue(null);
        ResolutionDeadlineDatePicker.setValue(null);
    }

    // Cancel button action: Clear input fields
    @FXML
    private void CancelButtonOnAction(MouseEvent event) {
        ComplaintIDTextField.clear();
        CustomerNameTextField.clear();
        ComplaintDescriptionTextField.clear();
        ComplaintStatusComboBox.setValue(null);
        AssignedDepartmentComboBox.setValue(null);
        PriorityComboBox.setValue(null);
        ComplaintDateDatePicker.setValue(null);
        ResolutionDeadlineDatePicker.setValue(null);
    }
}
