module com.changezitech.changezitemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.changezitech.changezitemplate to javafx.fxml;
    opens controllers to javafx.fxml;
    exports com.changezitech.changezitemplate;
}
