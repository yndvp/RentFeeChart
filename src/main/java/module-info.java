module com.example.rentfeechart {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.rentfeechart to javafx.fxml;
    exports com.example.rentfeechart;
    exports com.example.rentfeechart.Controllers;
    opens com.example.rentfeechart.Controllers to javafx.fxml;
    exports com.example.rentfeechart.Models;
    opens com.example.rentfeechart.Models to javafx.fxml;
}