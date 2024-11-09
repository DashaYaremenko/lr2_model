module org.example.lr2_model {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lr2_model to javafx.fxml;
    exports org.example.lr2_model;
}