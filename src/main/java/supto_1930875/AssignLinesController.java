package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AssignLinesController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> taskComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> lineComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        lineComboBox.getItems().addAll("Line A", "Line B", "Line C");

        taskComboBox.getItems().addAll("Install Brakes", "Assemble Engine", "Paint Car");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Production Manager Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void assignTaskOnAction(ActionEvent actionEvent) {

        String line = lineComboBox.getValue();
        String task = taskComboBox.getValue();

        if (line == null || task == null) {
            outputLabel.setText("Error: Please select a production line and task.");
            return;
        }

        String assignment = "Production Line: " + line + " - Task: " + task;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("lineAssignments.txt", true));
            writer.write(assignment);
            writer.newLine();
            writer.close();
            outputLabel.setText("Task assigned successfully: " + assignment);
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to save assignment - " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void viewAssignedLineOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/lineView.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Production Line View Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}