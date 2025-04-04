package oop.project.carmanufacturing;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.util.List;

public class LoginController {

    private List<User> userList;
    @javafx.fxml.FXML
    private ComboBox<User> userComboBox;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        UserManager manager = new UserManager();
        userList = manager.getUserList();
    }

    @javafx.fxml.FXML
    public void login(ActionEvent actionEvent) throws IOException {
        for (User u: userList) {
            if (userComboBox.getItems().equals(u.getUsername())
                    && passwordField.getText().equals(u.getPassword())) {
                messageLabel.setText("Log in successful!");
            }
        }
        messageLabel.setText("Invalid username or password!");
    }
}