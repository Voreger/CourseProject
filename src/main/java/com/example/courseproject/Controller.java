package com.example.courseproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;
    @FXML
    void initialize(){
        SignInButton.setOnAction(actionEvent -> {
            System.out.println("Кнопка войти");
            System.out.println(loginField.getText());
            System.out.println(passwordField.getText());

            SignInButton.getScene().getWindow().hide();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxmlFiles/mainPage.fxml"));
            try {
                loader1.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader1.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мебельная фабрика");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
        SignUpButton.setOnAction(actionEvent -> {
            SignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxmlFiles/signIn.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мебельная фабрика");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}
