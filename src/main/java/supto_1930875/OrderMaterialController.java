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

import java.io.IOException;

public class OrderMaterialController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> materialsComboBox;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    @javafx.fxml.FXML
    public void initialize() {
        materialsComboBox.getItems().setAll("Steel", "Tires", "Glass", "Rubber","Plastic");
    }

    @javafx.fxml.FXML
    public void submitOrderOnAction(ActionEvent actionEvent) {
        if (materialsComboBox.getValue()==null){
            outputLabel.setText("Please select one material!");
            return;
        }
        if (quantityTextField.getText().isEmpty()){
            outputLabel.setText("Select at least one material!");
            return;
        }
        else outputLabel.setText("Order Submitted Successfully!");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Dashboard");
            stage.show();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}