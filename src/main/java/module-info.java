module co.edu.uniquindio.preparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens co.edu.uniquindio.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.parcial2;
    exports co.edu.uniquindio.parcial2.controller;
    opens co.edu.uniquindio.parcial2.controller to javafx.fxml;
    exports co.edu.uniquindio.parcial2.view;
    opens co.edu.uniquindio.parcial2.view to javafx.fxml;
}