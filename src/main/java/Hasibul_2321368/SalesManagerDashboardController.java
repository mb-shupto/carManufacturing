package Hasibul_2321368;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesManagerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void HandleCustomerComplaintsOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Hasibul_2321368/Customer Complaints.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Complaints");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void ManageDealerRelationshipOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Hasibul_2321368/SM Manage Dealer Relationship.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("SM Manage Dealer Relationship");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void CustomerOrderManagementOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Hasibul_2321368/SM Customer Order Management view.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("SM Customer Order Management view");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}