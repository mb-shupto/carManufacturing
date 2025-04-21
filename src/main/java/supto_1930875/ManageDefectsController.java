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

public class ManageDefectsController
{
    @javafx.fxml.FXML
    private ComboBox<String> teamComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> defectComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        defectComboBox.getItems().addAll("Defect 1: Faulty Brake", "Defect 2: Paint Scratch", "Defect 3: Engine Noise");

        teamComboBox.getItems().addAll("Team A", "Team B", "Team C");

        statusComboBox.getItems().addAll("In Progress", "Fixed");

        outputLabel.setText(""); // Clear the label initially
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
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
    public void updateReportOnAction(ActionEvent actionEvent) {

        String defect = defectComboBox.getValue();
        String team = teamComboBox.getValue();
        String status = statusComboBox.getValue();

        if (defect == null || team == null || status == null) {
            outputLabel.setText("Error: Please select a defect, team, and status.");
            return;
        }

        // Prepare the output message
        String output = defect + " assigned to " + team + " and marked as " + status + ".";

        // Save to defect_reports.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("defectReports.txt", true));
            writer.write(output);
            writer.newLine();
            writer.close();
            outputLabel.setText("Report updated successfully: " + output);
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to save report - " + e.getMessage());
        }


    }

    @javafx.fxml.FXML
    public void viewDefectReportsOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/defectOutput.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Defect Output Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}