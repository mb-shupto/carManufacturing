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

public class ReviewCostsController
{
    @javafx.fxml.FXML
    private TextArea costsTextArea;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> periodComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        periodComboBox.getItems().addAll("Last 7 Days", "Last Month");
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
    public void reviewCostsOnAction(ActionEvent actionEvent) {

        String period = (String) periodComboBox.getValue();
        if (period == null) {
            outputLabel.setText("Error: Please select a time period.");
            return;
        }

        String costs = "";
        try {
            File file = new File("production_costs.txt");
            if (!file.exists()) {
                costs = period + ":\nMaterials: $10,000\nLabor: $5,000\nOverhead: $2,000";
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder(period + ":\n");
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                costs = sb.toString();
            }
        } catch (IOException e) {
            outputLabel.setText("Error: Failed to load costs - " + e.getMessage());
            return;
        }

        costsTextArea.setText(costs);
        outputLabel.setText("Costs reviewed for " + period + ". Report exported (simulated).");
    }
}