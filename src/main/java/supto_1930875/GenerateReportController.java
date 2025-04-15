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

import java.io.FileWriter;
import java.io.IOException;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private TextArea reportTextArea;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll("Scheduled Tasks", "Production Progress", "Material Orders","Quality Control");
    }

    @javafx.fxml.FXML
    public void generateOnAction(ActionEvent actionEvent) {
        // Check if reportTypeComboBox has a selection and reportTextArea is not empty
        if (reportTypeComboBox.getValue() == null) {
            outputLabel.setText("Please select a report type!");
            return;
        }
        if (reportTextArea.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter text in the report area!");
            return;
        }

        // Proceed with file writing if conditions are met
        try (FileWriter fileWriter = new FileWriter("report.txt")) {
            fileWriter.write(reportTextArea.getText());
            outputLabel.setText("Generated Report Successfully!");
        } catch (IOException e) {
            outputLabel.setText("Could not write to file!");
        }
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
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}