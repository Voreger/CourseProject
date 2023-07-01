package com.example.courseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        });
        SignUpButton.setOnAction(actionEvent -> {
            System.out.println("Кнопка зарегистрироваться");
        });

    }

}
