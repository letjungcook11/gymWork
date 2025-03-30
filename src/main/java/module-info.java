module com.example.gymwork {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gymwork to javafx.fxml;
    exports com.example.gymwork;
}