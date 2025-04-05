package oop.project.carmanufacturing;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.util.List;

public class LoginController {
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label messageLabel;

    private UserManager userManager = new UserManager();

    @FXML
    public void initialize() {
        UserManager manager = new UserManager();
        userList = manager.getUserList();
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