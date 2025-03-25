module oop.project.carmanufacturing {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.project.carmanufacturing to javafx.fxml;
    exports oop.project.carmanufacturing;
}