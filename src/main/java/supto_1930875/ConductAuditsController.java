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

public class ConductAuditsController
{
    @javafx.fxml.FXML
    private ComboBox<String> resultComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> batchComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        batchComboBox.getItems().addAll("Batch 1", "Batch 2", "Batch 3");

        resultComboBox.getItems().addAll("Compliant", "Non-Compliant");
    }


    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException{

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
    public void confirmAuditOnAction(ActionEvent actionEvent) {

        String batch = batchComboBox.getValue();
        String result = resultComboBox.getValue();

        if (batch == null || result == null) {
            outputLabel.setText("Error! Please select a batch and audit result.");
            return;
        }

        outputLabel.setText("Audit Result" + batch + ": " + result);


        outputLabel.setText("Success! " + "Audit for " + batch + " completed and shared with management.");
    }
}