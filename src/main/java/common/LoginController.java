package common;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginController {
    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    private UserManager userManager = new UserManager();

    @FXML
    public void initialize() {
        // putting items on the combo box
        userComboBox.getItems().addAll(userManager.getAllUsernames());
    }

    @FXML
    public void login() {
        String username = userComboBox.getValue();
        String password = passwordField.getText();

        if (userManager.validateLogin(username, password)) {
            messageLabel.setText("Login successful!");
        } else {
            messageLabel.setText("Invalid credentials!");
        }
    }
}