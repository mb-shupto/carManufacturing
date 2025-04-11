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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginController {
    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    private PasswordField passwordField;

    private UserManager userManager = new UserManager();
    @FXML
    private Label outputLabel;

    private List<String[]> credentials = new ArrayList<>();

    @FXML
    public void initialize() {
        credentials.add(new String[]{"Production Manager","1234"});
        credentials.add(new String[]{"QA Engineer", "1122"});

        for (String[] credential : credentials){
            userComboBox.getItems().add(credential[0]);
        }
    }

    @FXML
    public void login() {
        String username = userComboBox.getValue();
        String password = passwordField.getText();

        if (userManager.validateLogin(username, password)) {
            outputLabel.setText("Login successful!");
        } else {
            outputLabel.setText("Invalid credentials!");
        }
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String user = userComboBox.getValue();
        String password = passwordField.getText();

            if (user != null && password != null){
                for (String[] credential : credentials){
                    if (credential[0].equals(user) && credential[1].equals(password));
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto_1930875/productionManager.fxml"));
                        Parent root = fxmlLoader.load();
                        Node source = (Node) actionEvent.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Production Manager Dashboard");
                        stage.show();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                        outputLabel.setText("Error loading the dashboard!");
                        return;
                    }
                }
            }
            outputLabel.setText("Invalid User or Password");

    }

    public List<String[]> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<String[]> credentials) {
        this.credentials = credentials;
    }
}