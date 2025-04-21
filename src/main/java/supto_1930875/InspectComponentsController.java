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

public class InspectComponentsController
{
    @javafx.fxml.FXML
    private ComboBox<String> componentComboBox;
    @javafx.fxml.FXML
    private TextArea outputTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> resultComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        componentComboBox.getItems().addAll("Brakes", "Engine", "Transmission", "Paint");

        resultComboBox.getItems().addAll("Pass", "Fail");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("QA Engineer Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void recordInspectionOnAction(ActionEvent actionEvent) {
        String component = componentComboBox.getValue();
        String result = resultComboBox.getValue();

        if (component == null || result == null) {
            outputLabel.setText("Error: Please select a Component & Inspection result.");
            return;
        }

        // Prepare the inspection result
        String output = "Component: " + component + " , Result: " + result;
        if (result.equals("Fail")) {
            output += " (Flagged for Rework)";
        }
        outputTextArea.setText(output);

        // Save to inspection_results.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inspectionResults.txt", true));
            writer.write(output);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to save inspection result - " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void viewInspectionOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/viewInspections.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("View Inspections Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}