package common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label outputLabel;

    private UserManager userManager = new UserManager();

    @FXML
    public void initialize() {
        // Populate the ComboBox with usernames from UserManager
        String[] usernames = userManager.getAllUsernames();
        userComboBox.getItems().addAll(usernames);
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String username = userComboBox.getValue();
        String password = passwordField.getText();

        // Validate inputs
        if (username == null || password.isEmpty()) {
            outputLabel.setText("Please select a user and enter a password.");
            return;
        }

        // Validate credentials using UserManager
        if (userManager.validateLogin(username, password)) {
            outputLabel.setText("Login successful!");

            // Determine the dashboard based on the user role
            String fxmlFile;
            String title;
            if (username.equals("Production Manager")) {
                fxmlFile = "productionManager.fxml";
                title = "Production Manager Dashboard";
            } else if (username.equals("QA Engineer")) {
                fxmlFile = "qaEngineer.fxml";
                title = "QA Engineer Dashboard";
            } else {
                outputLabel.setText("Error: Unknown user role.");
                return;
            }

            // Navigate to the appropriate dashboard
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/" + fxmlFile));
                Parent root = fxmlLoader.load();
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle(title);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                outputLabel.setText("Error loading the dashboard: " + e.getMessage());
            }
        } else {
            outputLabel.setText("Invalid username or password.");
        }
    }
}