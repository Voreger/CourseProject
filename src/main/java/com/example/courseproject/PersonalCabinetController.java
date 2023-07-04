package com.example.courseproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PersonalCabinetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignInButton;

    @FXML
    private Text firstNameTextField;

    @FXML
    private Text genderTextField;

    @FXML
    private Text loginTextField;
    @FXML
    private Button mainPageButton;

    @FXML
    private Text secondNameTextField;

    @FXML
    void initialize() {
        firstNameTextField.setText("Владимир");
        secondNameTextField.setText("Горьков");
        loginTextField.setText("Voreger1234");
        genderTextField.setText("Мужской");
    }

}
