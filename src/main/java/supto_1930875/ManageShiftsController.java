package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManageShiftsController
{
    @javafx.fxml.FXML
    private ComboBox<String> workerComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> shiftComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        workerComboBox.getItems().addAll("Worker A", "Worker B", "Worker C");

        shiftComboBox.getItems().addAll("Morning Shift", "Afternoon Shift", "Night Shift");

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
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void assignShiftOnAction(ActionEvent actionEvent) {

        String worker = workerComboBox.getValue();
        String shift = shiftComboBox.getValue();

        if (worker == null || shift == null) {
            outputLabel.setText("Error: Please select a worker and shift.");
            return;
        }

        // Prepare the shift assignment
        String assignment = "Worker: " + worker + " - Shift: " + shift;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("shiftSchedule.txt", true));
            writer.write(assignment);
            writer.newLine();
            writer.close();
            outputLabel.setText("Shift assigned successfully: " + assignment);
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to save shift assignment - " + e.getMessage());
        }
    }
}