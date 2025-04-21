package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductionManagerController {


    @javafx.fxml.FXML
    public void scheduleTaskOnAction(ActionEvent actionEvent) throws IOException {
            try {
                // Load the FXML
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/scheduleTask.fxml"));
                Parent root = fxmlLoader.load();

                // Get the current stage properly
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                // Set the new scene
                stage.setScene(new Scene(root));
                stage.setTitle("Task Schedule");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                // Show error to user if needed
            }
        }

    @javafx.fxml.FXML
    public void monitorTaskOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/monitorProgress.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Monitor Task");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @javafx.fxml.FXML
    public void assignShiftsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/assignShiftss.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Order Material Dashboard");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/generateReport.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Monitor Task");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Dashboard");
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void orderMaterialsOnAction (ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/orderMaterial.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Order Material Dashboard");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void assignProductionLinesOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/assignLines.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Assign Production Lines Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @javafx.fxml.FXML
    public void reviewCostsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/reviewCosts.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Review Production Costs Dashboard");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
