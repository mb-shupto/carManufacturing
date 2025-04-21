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

public class ViewInspectionsController
{
    @javafx.fxml.FXML
    private TextArea inspectionTextArea;

    @javafx.fxml.FXML
    public void initialize() {

        // Load all saved inspection results from inspection_results.txt
        StringBuilder inspections = new StringBuilder();
        File file = new File("inspectionResults.txt");

        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    inspections.append(line).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                inspections.append("Error: Failed to load inspection results - ").append(e.getMessage());
            }
        } else {
            inspections.append("No inspection results found.");
        }

        inspectionTextArea.setText(inspections.toString());
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/inspectComponents.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspect Car Components Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}