module com.morsecode.morsecode {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.morsecode.morsecode to javafx.fxml;
    exports com.morsecode.morsecode;
    exports com.morsecode.morsecode.controller;
    opens com.morsecode.morsecode.controller to javafx.fxml;
    exports com.morsecode.morsecode.view;
    opens com.morsecode.morsecode.view to javafx.fxml;
}