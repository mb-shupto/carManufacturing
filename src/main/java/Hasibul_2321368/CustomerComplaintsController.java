package Hasibul_2321368;

import Hasibul_2321368.modelclass.CustomerComplaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.time.format.DateTimeFormatter;

public class CustomerComplaintsController {

    @javafx.fxml.FXML
    private TextField ComplaintIDTextField;
    @javafx.fxml.FXML
    private TextField CustomerNameTextField;
    @javafx.fxml.FXML
    private TextField ComplaintDescriptionTextField;
    @javafx.fxml.FXML
    private ComboBox<String> ComplaintStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> AssignedDepartmentComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> PriorityComboBox;
    @javafx.fxml.FXML
    private DatePicker ComplaintDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker ResolutionDeadlineDatePicker;

    @javafx.fxml.FXML
    private TableView<CustomerComplaint> complaintTableView;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> ComplaintIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> CustomerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> ComplaintStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> AssignedDepartmentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> ComplaintDescriptionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> ComplaintDatetableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> ResolutionDeadlineTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CustomerComplaint, String> PriorityTableColumn;

    // Observable list for storing customer complaints
    private ObservableList<CustomerComplaint> complaintList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize ComboBoxes
        ComplaintStatusComboBox.getItems().addAll("Pending", "Resolved", "In Progress");
        AssignedDepartmentComboBox.getItems().addAll("Customer Service", "Tech Support", "Sales");
        PriorityComboBox.getItems().addAll("Low", "Medium", "High");

        // Set up TableView columns

        ComplaintIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("comID"));
        ComplaintIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("comIDTable"));

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
    @javafx.fxml.FXML
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
    @javafx.fxml.FXML
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
