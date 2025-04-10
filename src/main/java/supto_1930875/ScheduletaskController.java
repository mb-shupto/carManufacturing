package supto_1930875;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class ScheduletaskController
{
    @javafx.fxml.FXML
    private ComboBox<String> assignWorkerComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private Button assignTaskOnAction;
    @javafx.fxml.FXML
    private DatePicker deadLineDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> pickTaskComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }
}