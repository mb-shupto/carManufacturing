package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

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
        
        if (pickTaskComboBox.getValue()==null){
            outputLabel.setText("Must select a task to continue!");
            return;
        }

        if (assignWorkerComboBox.getValue()==null){
            outputLabel.setText("Must select a team to continue!");
            return;
        }
        if (deadLineDatePicker.getValue()==null){
            outputLabel.setText("Must select a valid date!");
            return;
        }

        outputLabel.setText("Assigned Work Successfully!");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Production Manager Dashboard");
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}