module main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens mineField;

    exports mineField;
}