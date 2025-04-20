package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TestCarController
{
    @javafx.fxml.FXML
    private ComboBox<String> carComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> resultComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        carComboBox.getItems().addAll("Car 1", "Car 2", "Car 3");

        resultComboBox.getItems().addAll("Pass", "Fail");
    }


    @javafx.fxml.FXML
    public void confirmTest(ActionEvent actionEvent) {

        String car = carComboBox.getValue();
        String result = resultComboBox.getValue();

        if (car == null || result == null) {
            outputLabel.setText("Error, Please select a car and test result.");
            return;
        }

        // Display test result (Event-4)
        outputLabel.setText("Test Result" + ": " + result);

        // Approve or reject based on test result (Event-5)
        String status = result.equals("Pass") ? "Approved" : "Rejected";
        outputLabel.setText("Status" + " has been " + status + "!");
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
}