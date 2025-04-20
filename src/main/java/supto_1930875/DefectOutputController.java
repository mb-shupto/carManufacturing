package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DefectOutputController
{
    @javafx.fxml.FXML
    private TextArea outputTextArea;

    @javafx.fxml.FXML
    public void initialize() {
        // Load all saved reports from defect_reports.txt
        StringBuilder reports = new StringBuilder();
        File file = new File("defectReports.txt");

        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    reports.append(line).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                reports.append("Error: Failed to load reports - ").append(e.getMessage());
            }
        } else {
            reports.append("No defect reports found.");
        }

        outputTextArea.setText(reports.toString());
    }

    public void setOutput(String output) {
        outputTextArea.setText(output);
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/manageDefects.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Manager Defect Reports Dashboard");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}