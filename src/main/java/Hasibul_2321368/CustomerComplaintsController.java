package Hasibul_2321368;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CustomerComplaintsController
{
    @javafx.fxml.FXML
    private TextField ComplaintIDTextField;
    @javafx.fxml.FXML
    private TextField CustomerNameTextField;



    @javafx.fxml.FXML
    private TableColumn ComplaintIDTableColumn;

    @javafx.fxml.FXML
    private TableColumn ComplaintStatusTableColumn;
    @javafx.fxml.FXML
    private Button CancelButton;
    @javafx.fxml.FXML
    private TableColumn ComplaintDatetableColumn;
    @javafx.fxml.FXML
    private TableColumn PriorityTableColumn;
    @javafx.fxml.FXML
    private Button ConfirmButton;
    @javafx.fxml.FXML
    private ComboBox ComplaintStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn ComplaintDescriptionTableColumn;
    @javafx.fxml.FXML
    private DatePicker ResolutionDeadlineDatePicker;
    @javafx.fxml.FXML
    private TableColumn CustomerNameTableColumn;
    @javafx.fxml.FXML
    private ComboBox PriorityComboBox;
    @javafx.fxml.FXML
    private TableColumn AssignedDepartmentTableColumn;
    @javafx.fxml.FXML
    private DatePicker ComplaintDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn ResolutionDeadlineTableColumn;
    @javafx.fxml.FXML
    private TextArea ComplaintDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox AssignedDepartmentComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ConfirmButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CancelButtonOnAction(ActionEvent actionEvent) {
    }
}