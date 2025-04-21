package supto_1930875;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitorProgressController {
    @FXML private TableColumn<Task, String> taskColumn;
    @FXML private ComboBox<String> taskUpdateComboBox;
    @FXML private TableColumn<Task, String> progressColumn;
    @FXML private TableColumn<Bottleneck, String> statusColumn;
    @FXML private TextField newProgressTextField;
    @FXML private ComboBox<String> resolveBottleneckComboBox;
    @FXML private TableColumn<Bottleneck, String> bottleneckColumn;
    @FXML private Label updateOutputLabel;
    @FXML private Label resolveOutputLabel;
    @FXML private TableView<Task> taskProgressTableView;
    @FXML private ComboBox<String> currentStatusComboBox;
    @FXML private TableView<Bottleneck> bottleneckStatusTableView;

    private List<Task> taskList = new ArrayList<>();
    private List<Bottleneck> bottleneckList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Initialize task list with sample data
        taskList.add(new Task("Assemble Engine", "50%"));
        taskList.add(new Task("Paint Body", "30%"));
        taskList.add(new Task("Attach Suspension", "70%"));
        taskList.add(new Task("Add Wheels", "20%"));
        taskList.add(new Task("Install Electronics", "40%"));

        // Initialize bottleneck list with sample data
        bottleneckList.add(new Bottleneck("Assemble Engine", "In Progress"));
        bottleneckList.add(new Bottleneck("Paint Body", "Delayed"));
        bottleneckList.add(new Bottleneck("Attach Suspension", "In Progress"));
        bottleneckList.add(new Bottleneck("Add Wheels", "Stopped"));
        bottleneckList.add(new Bottleneck("Install Electronics", "In Progress"));

        // Set up Task TableView
        taskColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progress"));
        taskProgressTableView.getItems().setAll(taskList);

        // Set up Bottleneck TableView
        bottleneckColumn.setCellValueFactory(new PropertyValueFactory<>("bottleneckName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        bottleneckStatusTableView.getItems().setAll(bottleneckList);

        // Populate ComboBoxes
        taskUpdateComboBox.getItems().addAll("Assemble Engine", "Paint Body", "Attach Suspension", "Add Wheels", "Install Electronics");
        resolveBottleneckComboBox.getItems().addAll("Assemble Engine", "Paint Body", "Attach Suspension", "Add Wheels", "Install Electronics");
        currentStatusComboBox.getItems().addAll("In Progress", "Delayed", "Stopped", "Completed");
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root, 660, 525));
            stage.setTitle("Production Manager Dashboard");
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
            updateOutputLabel.setText("Error loading dashboard: " + exception.getMessage());
        }
    }

    @FXML
    public void updateProgressOnAction(ActionEvent actionEvent) {
        String selectedTask = taskUpdateComboBox.getValue();
        String newProgress = newProgressTextField.getText();

        if (selectedTask == null || newProgress.trim().isEmpty()) {
            updateOutputLabel.setText("Please select a task and enter a new progress value.");
            return;
        }

        // Validate progress input (should be a percentage)
        try {
            int progressValue = Integer.parseInt(newProgress.replace("%", ""));
            if (progressValue < 0 || progressValue > 100) {
                updateOutputLabel.setText("Progress must be between 0 and 100.");
                return;
            }

            // Update the task's progress
            for (Task task : taskList) {
                if (task.getTaskName().equals(selectedTask)) {
                    task.setProgress(progressValue + "%");
                    break;
                }
            }

            // Refresh the TableView
            taskProgressTableView.getItems().setAll(taskList);
            updateOutputLabel.setText("Progress updated for " + selectedTask + ": " + progressValue + "%");
        } catch (NumberFormatException e) {
            updateOutputLabel.setText("Invalid progress value. Please enter a number (e.g., 75).");
        }
    }

    @FXML
    public void allocateResourceOnAction(ActionEvent actionEvent) {
        String selectedBottleneck = resolveBottleneckComboBox.getValue();
        String selectedStatus = currentStatusComboBox.getValue();

        if (selectedBottleneck == null || selectedStatus == null) {
            resolveOutputLabel.setText("Please select a bottleneck condition and status to resolve!");
            return;
        }

        // Update the bottleneck's status
        for (Bottleneck bottleneck : bottleneckList) {
            if (bottleneck.getBottleneckName().equals(selectedBottleneck)) {
                bottleneck.setStatus(selectedStatus);
                break;
            }
        }

        // Refresh the TableView
        bottleneckStatusTableView.getItems().setAll(bottleneckList);
        resolveOutputLabel.setText("Bottleneck " + selectedBottleneck + " status updated to " + selectedStatus);
    }

    public List<Bottleneck> getBottleneckList() {
        return bottleneckList;
    }

    public void setBottleneckList(List<Bottleneck> bottleneckList) {
        this.bottleneckList = bottleneckList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}