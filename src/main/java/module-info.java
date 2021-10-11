module com.example.rentfeechart {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.rentfeechart to javafx.fxml;
    exports com.example.rentfeechart;
}