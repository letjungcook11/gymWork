package com.example.gymwork;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SplashScreen extends Application {

    public RadioButton radioButtonMember;
    public RadioButton radioMemberTrainer;
    public FXMLLoader loader;
    public TextField usernameInput;
    public TextField passwordInput;
    public Button btnLogin;
    public Button btnRegister;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-splash.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1500,750);
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void onSetLoginClicked(ActionEvent actionEvent) throws IOException, SQLException {
        String usernameString = usernameInput.getText().trim();
        String passwordString = passwordInput.getText().trim();

        if (passwordString.isEmpty() || usernameString.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Null Credentials");
            alert.setHeaderText(null);
            alert.setContentText("Fields cannot be empty.");
            alert.showAndWait();
        }
        boolean isFound = DatabaseHelper.readLoginFromDatabase(usernameString,passwordString);
        if (isFound) {
                if (radioButtonMember.isSelected()) {
                    loader = new FXMLLoader(HelloApplication.class.getResource("DashBoard.fxml"));
                } else {
                    loader = new FXMLLoader(HelloApplication.class.getResource("DashBoardTrainer.fxml"));
                }
                Scene sceneT = new Scene(loader.load(), 1500, 750);
                Stage stageT = (Stage) btnLogin.getScene().getWindow();
                stageT.setScene(sceneT);
                stageT.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Username Not Found In The Server.");
            alert.setHeaderText(null);
            alert.setContentText("Username Not Found.");
            alert.showAndWait();
        }
    }

    public void onSetRegisterClicked(ActionEvent actionEvent) throws IOException {
        loader = new FXMLLoader(HelloApplication.class.getResource("RegisterScreen.fxml"));
        Scene newScene = new Scene(loader.load(),1500,750);
        Stage newStage = (Stage) btnRegister.getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }
}
