package com.example.gymwork;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class  DashboardTrainer extends Application {

    public ChoiceBox trainerChoiceBox;
    public ListView trainerListView;
    public TextArea trainerClickedWorkout;
    public Button trainerCreate;
    public Button trainerUpdate;
    public Button trainerDelete;
    public Button trainerLogout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    public void onSetCreateClicked(ActionEvent actionEvent) {
    }

    public void onSetUpdateClicked(ActionEvent actionEvent) {
    }

    public void onSetDeleteClicked(ActionEvent actionEvent) {
    }

    public void onSetLogout(ActionEvent actionEvent) {
    }
}
