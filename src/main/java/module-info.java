module oop.project.carmanufacturing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens common to javafx.fxml;
    opens supto_1930875 to javafx.fxml;

    exports common;
}
