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

public class ManageDefectsController
{
    @javafx.fxml.FXML
    private ComboBox<String> teamComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> defectComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        defectComboBox.getItems().addAll("Faulty Brake", "Paint Scratch", "Engine Noise");

        teamComboBox.getItems().addAll("Team A", "Team B", "Team C");

        statusComboBox.getItems().addAll("In Progress", "Fixed");
    }


    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {


        String defect = defectComboBox.getValue();
        String team = teamComboBox.getValue();
        String status = statusComboBox.getValue();

        if (defect == null || team == null || status == null) {
            outputLabel.setText("Error Please select a defect, team, and status.");
            return;
        }

        outputLabel.setText("Success! " + defect + " assigned to " + team + " and marked as " + status + ".");
    }
}