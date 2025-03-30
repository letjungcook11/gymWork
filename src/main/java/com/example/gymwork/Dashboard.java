package com.example.gymwork;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Dashboard extends Application {

    public ChoiceBox memberChoiceBox;
    public ListView memberListview;
    public TextArea memberChosenWorkout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    public void memberDoWorkout(ActionEvent actionEvent) {
    }

    public void memberBlockWorkout(ActionEvent actionEvent) {
    }

    public void onSetLogout(ActionEvent actionEvent) {
    }
}
