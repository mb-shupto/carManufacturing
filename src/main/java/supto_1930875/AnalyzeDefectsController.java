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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalyzeDefectsController {
    @javafx.fxml.FXML
    private TextArea trendsTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> periodComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        periodComboBox.getItems().addAll("Last 7 Days", "Last 30 Days");
    }


    @javafx.fxml.FXML
    public void analyzeDefects(ActionEvent actionEvent) {

        String period = periodComboBox.getValue();
        if (period == null) {
            outputLabel.setText("Error! Please select a period.");
            return;
        }
        String trends = "";
        try {
            File file = new File("defects.txt");
            if (!file.exists()) {
                trends = period + ":\nBrake Issues: 3\nPaint Issues: 2\nEngine Noise: 1";
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder(period + ":\n");
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                trends = sb.toString();
            }
        } catch (IOException e) {
            outputLabel.setText("Error! Failed to load defect trends: " + e.getMessage());
            return;
        }

        trendsTextArea.setText(trends);
        outputLabel.setText("Success! Defect trends analyzed for " + period + ".");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("QA Engineer Dashboard");
            stage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}