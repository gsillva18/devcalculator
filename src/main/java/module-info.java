module com.example.devcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.apache.commons.lang3;
    requires lombok;

    opens com.example.devcalculator to javafx.fxml;
    opens com.example.devcalculator.controllers to javafx.fxml;
    exports com.example.devcalculator;
    exports com.example.devcalculator.controllers;
}