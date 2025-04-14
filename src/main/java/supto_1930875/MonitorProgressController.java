package supto_1930875;

import javafx.event.ActionEvent;
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

public class MonitorProgressController
{
    @javafx.fxml.FXML
    private TableColumn<Task, String> taskColumn;
    @javafx.fxml.FXML
    private ComboBox<String> taskUpdateComboBox;
    @javafx.fxml.FXML
    private TableColumn<Task, String> progressColumn;
    @javafx.fxml.FXML
    private TableColumn<Task, String> statusColumn;
    @javafx.fxml.FXML
    private TextField newProgressTextField;
    @javafx.fxml.FXML
    private ComboBox<String> resolveBottleneckComboBox;
    @javafx.fxml.FXML
    private TableColumn<Task, String> bottleneckColumn;
    @javafx.fxml.FXML
    private Label updateOutputLabel;
    @javafx.fxml.FXML
    private Label resolveOutputLabel;
    @javafx.fxml.FXML
    private TableView<Task> taskProgressTableView;
    @javafx.fxml.FXML
    private ComboBox<String> currentStatusComboBox;
    @javafx.fxml.FXML
    private TableView<String> bottleneckStatusTableView;

    private List<Task> taskList  = new ArrayList<>();
    private List<Bottleneck> bottleneckList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        TableView<Task> tableView = new TableView<>();

        TableColumn<Task, String> taskColumn = new TableColumn<>("Task Value");
        taskColumn.setCellValueFactory(new PropertyValueFactory<>("TaskValue"));

        TableColumn<Task, Integer> progressColumn = new TableColumn<>("Progress Value");
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("ProgressValue"));


        bottleneckColumn.setCellValueFactory(new PropertyValueFactory<>("Bottleneck"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));


        taskUpdateComboBox.getItems().addAll("Assemble Engine", "Paint Body", "Attach Suspension", "Add Wheels", "Install Electronics");
        resolveBottleneckComboBox.getItems().addAll("Assemble Engine", "Paint Body", "Attach Suspension", "Add Wheels", "Install Electronics");
        currentStatusComboBox.getItems().addAll("In Progress", "Delayed", "Stopped", "Completed");



    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
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
    public void updateProgressOnAction(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void allocateResourceOnAction(ActionEvent actionEvent) {
        if (resolveBottleneckComboBox.getValue()==null){
                resolveOutputLabel.setText("Please select a bottleneck condition to resolve!");
                return;
        }
        resolveOutputLabel.setText("Condition will be applied for resolving!");
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