package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LineViewController
{
    @javafx.fxml.FXML
    private TextArea outputTextArea;

    @javafx.fxml.FXML
    public void initialize() {


        // Load all saved production line results from lineAssignments.txt
        StringBuilder inspections = new StringBuilder();
        File file = new File("lineAssignments.txt");

        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    inspections.append(line).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                inspections.append("Error: Failed to load line assignment results - ").append(e.getMessage());
            }
        } else {
            inspections.append("No assignment results found.");
        }

        outputTextArea.setText(inspections.toString());
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/assignLines.fxml"));
            Parent root = fxmlLoader.load();
            Node scene = (Node) actionEvent.getSource();
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Assign Production Lines Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}