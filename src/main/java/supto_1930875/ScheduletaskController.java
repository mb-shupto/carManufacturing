package supto_1930875;

import javafx.event.ActionEvent;
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
    private DatePicker deadLineDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> pickTaskComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        assignWorkerComboBox.getItems().setAll("Team-1","Team-2", "Team-3", "Team-4", "Team-5" );
        pickTaskComboBox.getItems().setAll("Assemble Engine", "Attach Suspension", "Paint Body", "Add Wheel", "Test Battery");
    }

    @javafx.fxml.FXML
    public void assignTaskOnAction(ActionEvent actionEvent) {


        if (assignWorkerComboBox.getValue()==null){
            outputLabel.setText("Must select a team to continue!");
            return;
        }

        if (pickTaskComboBox.getValue()==null){
            outputLabel.setText("Must select a task to continue!");
            return;
        }

        if (deadLineDatePicker.getValue()==null){
            outputLabel.setText("Must select a valid date!");
            return;
        }

        outputLabel.setText("Assigned Work Successfully!");
    }
}