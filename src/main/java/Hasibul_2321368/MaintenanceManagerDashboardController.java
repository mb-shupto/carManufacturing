package Hasibul_2321368;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MaintenanceManagerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ScheduleVehicleMaintenanceOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Hasibul_2321368/Schedule-Vehicle-Maintenance-View1.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Schedule-Vehicle-Maintenance-View");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void MonitorMachinePerformanceOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Hasibul_2321368/Monitor-Machine-Performance-View.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Monitor-Machine-Performance-View");
            stage.show();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}