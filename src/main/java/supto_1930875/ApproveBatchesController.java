package supto_1930875;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class ApproveBatchesController {
    @FXML private TableView<Batch> batchTable;
    @FXML private TableColumn<Batch, String> batchIdCol;
    @FXML private TableColumn<Batch, String> testResultCol;
    @FXML private TableColumn<Batch, String> statusCol;

    private ArrayList<Batch> batches = new ArrayList<>();
    @FXML
    private Label outputLabel;

    @FXML
    private void initialize() {
        batchIdCol.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        testResultCol.setCellValueFactory(new PropertyValueFactory<>("testResult"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        try {
            File file = new File("batches.txt");
            if (!file.exists()) {
                // Initialize with dummy data if file doesn't exist
                batches.add(new Batch("Batch 1", "PASS", "Pending"));
                batches.add(new Batch("Batch 2", "FAIL", "Pending"));
                saveToFile();
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    batches.add(Batch.fromString(line));
                }
                reader.close();
            }
        } catch (IOException e) {
            outputLabel.setText("eror! Failed to load batches: " + e.getMessage());
        }

        batchTable.getItems().addAll(batches);
    }

    @FXML
    private void approveBatch() {
        updateBatchStatus("Approved");
    }

    @FXML
    private void rejectBatch() {
        updateBatchStatus("Rejected");
    }

    private void updateBatchStatus(String status) {
        Batch selectedBatch = batchTable.getSelectionModel().getSelectedItem();
        if (selectedBatch == null) {
            outputLabel.setText("Error! Please select a batch.");
            return;
        }

        selectedBatch.setStatus(status);
        saveToFile();
        batchTable.refresh();
        outputLabel.setText("Success" + selectedBatch.getBatchId() + " has been " + status.toLowerCase() + ".");
    }

    private void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("batches.txt"));
            for (Batch batch : batches) {
                writer.write(batch.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            outputLabel.setText("Error Failed to save batches: " + e.getMessage());
        }
    }


    @FXML
    public void backOnAction(ActionEvent actionEvent) {

    }

    public void backOnAction(javafx.event.ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/qaEngineer.fxml"));
        Parent root = fxmlLoader.load();
        Node scene = (Node) actionEvent.getSource();
        Stage stage = (Stage) scene.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QA Engineer Dashboard");
        stage.show();
    }catch (IOException e){
        e.printStackTrace();
    }

    }
}