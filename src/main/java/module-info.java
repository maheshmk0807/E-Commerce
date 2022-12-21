module major.ecommerce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens major.ecommerce to javafx.fxml;
    exports major.ecommerce;
}