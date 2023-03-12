module com.example.javasms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javasms to javafx.fxml;
    exports com.example.javasms;
}