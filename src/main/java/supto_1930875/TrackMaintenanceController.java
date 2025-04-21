package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TrackMaintenanceController
{
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> machineComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        machineComboBox.getItems().addAll("Welding Robot", "Assembly Arm", "Paint Sprayer");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {

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

    @javafx.fxml.FXML
    public void logMaintenanceOnAction(ActionEvent actionEvent) {

        String machine = machineComboBox.getValue();
        String notes = notesTextArea.getText();

        if (machine == null || notes.trim().isEmpty()) {
            outputLabel.setText("Error: Please select a machine and enter notes.");
            return;
        }

        String record = "Machine: " + machine + " , Notes: " + notes;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("maintenanceRecords.txt", true));
            writer.write(record);
            writer.newLine();
            writer.close();
            outputLabel.setText("Maintenance logged successfully: " + record);
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to save maintenance record - " + e.getMessage());
        }
    }
}