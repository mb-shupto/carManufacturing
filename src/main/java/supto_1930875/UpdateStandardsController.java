package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;

public class UpdateStandardsController
{
    @javafx.fxml.FXML
    private TextArea standardsTextArea;
    @javafx.fxml.FXML
    private Label updateLabel;

    @javafx.fxml.FXML

    public void initialize() {

        try {
            File file = new File("standards.txt");
            if (!file.exists()) {
                standardsTextArea.setText("1. Check brakes\n2. Inspect paint\n3. Test engine");
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                standardsTextArea.setText(sb.toString());
            }
        } catch (IOException e) {
            updateLabel.setText("Error: Failed to load standards: " + e.getMessage());
        }
    }


    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("QA Engineer Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void saveChangesOnAction(ActionEvent actionEvent) {

        String standards = standardsTextArea.getText();
        if (standards.trim().isEmpty()) {
            updateLabel.setText("Error: Standards cannot be empty!");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("standards.txt"));
            writer.write(standards);
            writer.close();
            updateLabel.setText("Success: Quality standards updated.");
        } catch (IOException e) {
            updateLabel.setText("Error: Failed to save standards: " + e.getMessage());
        }
    }
}