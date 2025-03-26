package oop.project.carmanufacturing;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label messageLabel;

    private List<User> userList;

    @javafx.fxml.FXML
    public void initialize() {
        UserManager manager = new UserManager();
        userList = manager.getUserList();
    }

    @javafx.fxml.FXML
    public void login(ActionEvent actionEvent) throws IOException {
        for (User u: userList) {
            if (usernameField.getText().equals(u.getUsername())
                    && passwordField.getText().equals(u.getPassword())) {
                messageLabel.setText("Log in successful!");
                // Now switch to the other scene
                Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage stage = (Stage) messageLabel.getScene().getWindow();
                stage.setScene(new Scene(root));

                return;
            }
        }
        messageLabel.setText("Invalid username or password!");
    }
}