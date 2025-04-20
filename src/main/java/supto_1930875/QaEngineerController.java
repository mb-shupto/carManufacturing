package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QaEngineerController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
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
    public void testFinishedCarOnAction(ActionEvent actionEvent) {try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/testCar.fxml"));
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
    public void inspectCarOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void conductQualityAuditOnAction(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/conductAudits.fxml"));
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
    public void approveProductionBatchOnAction(ActionEvent actionEvent)throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/approveBatches.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Approve Production Batches");
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void manageDefectReportOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/manageDefects.fxml"));
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
    public void trainInspectionTeamOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/trainTeam.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Approve Production Batches");
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void updateQualityStandardsOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/updateStandards.fxml"));
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
    public void analyzeDefectOnAction(ActionEvent actionEvent)  throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/analyzeDefects.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Analyze Defect Trends Dashboard");
            stage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}