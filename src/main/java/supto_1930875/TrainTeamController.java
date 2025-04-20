package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TrainTeamController
{
    @javafx.fxml.FXML
    private ComboBox<String> traineeComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField topicTextField;

    @javafx.fxml.FXML
    public void initialize() {
        traineeComboBox.getItems().addAll("Trainee A", "Trainee B", "Trainee C");
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void logTrainingOnAction(ActionEvent actionEvent) {

        String trainee = traineeComboBox.getValue();
        String topic = topicTextField.getText();

        if (trainee == null || topic.trim().isEmpty()) {
            outputLabel.setText("Error: Please select a trainee and enter a topic.");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("trainingLog.txt", true));
            writer.write(trainee + "," + topic);
            writer.newLine();
            writer.close();
            outputLabel.setText("Success: Training logged for " + trainee + ": " + topic);
        } catch (IOException e) {
            outputLabel.setText("Error! Failed to log training: " + e.getMessage());
        }
    }
}