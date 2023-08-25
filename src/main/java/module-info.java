module cookie {
    requires javafx.controls;
    requires javafx.fxml;
//    requires com.fasterxml.jackson.annotation;
//    requires com.fasterxml.jackson.core;
//    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens cookie to javafx.fxml;
    exports cookie;
    exports cookie.controller;
    //exports cookie.model;
    exports cookie.view;
    //exports cs3500.pa05.model.json;
    opens cookie.controller to javafx.fxml;
   // opens cookie.model;


}