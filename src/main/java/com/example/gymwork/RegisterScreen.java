package com.example.gymwork;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterScreen extends Application {

    public TextField registrationNameInput;
    public TextField registrationUsernameInput;
    public TextField registrationPasswordInput;
    public TextField registrationPasswordInputConfirmation;
    public TextField registrationAgeInput;

    public Button btnSubmit;
    public Button btnBack;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegisterScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1500,750);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onSetSubmitClicked(ActionEvent actionEvent) throws SQLException {
        String fieldNameInput = registrationNameInput.getText().trim();
        String fieldUsernameInput = registrationUsernameInput.getText().trim();
        String fieldPasswordInput = registrationPasswordInput.getText().trim();
        String fieldAgeInput = registrationAgeInput.getText().trim();
        String fieldPasswordInputConfirmation = registrationPasswordInputConfirmation.getText().trim();

        if (fieldNameInput.isEmpty() || fieldAgeInput.isEmpty() || fieldPasswordInput.isEmpty() || fieldUsernameInput.isEmpty()
           || fieldPasswordInputConfirmation.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Null Credentials");
            alert.setHeaderText(null);
            alert.setContentText("Fields cannot be null.");
            alert.showAndWait();
        } else if (fieldPasswordInputConfirmation != fieldPasswordInput){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Null Credentials");
            alert.setHeaderText(null);
            alert.setContentText("Password Confirmation Failed. Please Re-Input Again.");
            alert.showAndWait();
        } else {
            DatabaseHelper.saveUserToDatabase(fieldUsernameInput,fieldPasswordInput,fieldNameInput, fieldAgeInput);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Null Credentials");
            alert.setHeaderText(null);
            alert.setContentText("Fields cannot be null.");
            alert.showAndWait();
        }

    }

    public void onSetBackClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("RegisterScreen.fxml"));
        Scene scene = new Scene(loader.load(),1500,750);
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
