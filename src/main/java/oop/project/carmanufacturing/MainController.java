package oop.project.carmanufacturing;

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

public class MainController {
    @FXML
    private Label messageLabel;
    @FXML
    private TextField filterAge;
    @FXML
    private TableColumn<User, String> usernameCol;
    @FXML
    private TableColumn<User, Integer> ageCol;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> passwordCol;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private ComboBox<Integer> ageCB;
    @FXML
    private Label summaryLabel;

    private List<User> userList;

    public void initialize() {
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        for (int i = 18; i <= 80; i++)
            ageCB.getItems().add(i);

        UserManager manager = new UserManager();
        userList = manager.getUserList();

        tableView.getItems().addAll(userList);
    }

    @FXML
    public void filter(ActionEvent actionEvent) {
        try {
            messageLabel.setText("");
            int maxAge = Integer.parseInt(filterAge.getText());

            tableView.getItems().clear();
            for (User u : userList) {
                if (u.getAge() < maxAge)
                    tableView.getItems().add(u);
            }
        }
        catch (NumberFormatException e) {
            messageLabel.setText("Invalid input for filter!");
        }
    }

    @FXML
    public void addUser(ActionEvent actionEvent) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        int age = ageCB.getValue();

        if (username.isBlank() || password.isBlank()) {
            messageLabel.setText("Username and Password cannot be empty!");
            return;
        }

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                messageLabel.setText("Username is not unique");
                return;
            }
        }

        User u = new User(username, password, age);
        userList.add(u);
        tableView.getItems().add(u);
    }

    @FXML
    public void resetFilter(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(userList);
    }

    @FXML
    public void summary(ActionEvent actionEvent) {
        // maximum age
//        int maxAge = userList.getFirst().getAge();
//        for (User u: userList) {
//            if (u.getAge() > maxAge) {
//                maxAge = u.getAge();
//            }
//        }
//        summaryLabel.setText("Maximum age is " + maxAge);

        // minimum age
//        int minAge = userList.getFirst().getAge();
//        for (User u: userList) {
//            if (u.getAge() < minAge) {
//                minAge = u.getAge();
//            }
//        }
//        summaryLabel.setText("Minimum age is " + minAge);

        // average age
//        int sumAge = 0;
//        for (User u: userList) {
//            sumAge += u.getAge();
//        }
//        summaryLabel.setText("Average age is " + (double) sumAge / userList.size());

        // average password length
        int sumLength = 0;
        for (User u: userList) {
            sumLength += u.getPassword().length();
        }
        summaryLabel.setText("Average password length is " + (double) sumLength / userList.size());

    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}