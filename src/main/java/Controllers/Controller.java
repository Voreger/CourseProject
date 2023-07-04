package Controllers;

import Model.Const;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

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
    private Text errorText;
    @FXML
    void initialize(){
        SignInButton.setOnAction(actionEvent -> {
            System.out.println("Кнопка войти");
            System.out.println(loginField.getText());
            System.out.println(passwordField.getText());

            Const.showWindow(SignInButton, "mainPage.fxml");

        });
        SignUpButton.setOnAction(actionEvent -> {
            Const.showWindow(SignUpButton, "signIn.fxml");
        });

    }

}
