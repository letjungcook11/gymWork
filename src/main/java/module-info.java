module com.example.gymwork {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gymwork to javafx.fxml;
    exports com.example.gymwork;
}