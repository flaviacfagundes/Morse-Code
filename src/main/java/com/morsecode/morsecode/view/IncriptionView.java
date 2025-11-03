package com.morsecode.morsecode.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IncriptionView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(IncriptionView.class.getResource("/com/morsecode/morsecode/incription.fxml"));
        primaryStage.setScene(new Scene(fxmlLoader.load(), 1000, 450));
        primaryStage.setTitle("Conversor de Código Morse");
        primaryStage.show();
    }
}
