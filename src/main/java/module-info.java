module oop.project.carmanufacturing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.management;

    opens common to javafx.fxml;
    opens supto_1930875 to javafx.fxml;
    opens Hasibul_2321368 to javafx.fxml;

    exports supto_1930875;
    exports Hasibul_2321368;
    exports common;
}
