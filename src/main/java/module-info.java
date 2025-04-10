module oop.project.carmanufacturing {
    requires javafx.controls;
    requires javafx.fxml;

    opens common to javafx.fxml;
    exports common;
}
