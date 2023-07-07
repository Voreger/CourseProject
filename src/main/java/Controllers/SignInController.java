package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;
import Model.Const;
import Model.User;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup Group;

    @FXML
    private ToggleGroup Group1;
    @FXML
    private Text ErrorText;
    @FXML
    private Button SignUpButton;

    @FXML
    private RadioButton factoryRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField loginField;

    @FXML
    private RadioButton manRadioButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton shopRadioButton;
    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {
        dbConnection dbConnect = new dbConnection();

        SignUpButton.setOnAction(actionEvent ->{
            if(loginField.getText().isEmpty() || passwordField.getText().isEmpty() || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty())
                ErrorText.setVisible(true);
            else {
                dbConnect.signUpUser(getUser());
                Const.showWindow(SignUpButton, "authorization.fxml");
            }
        });
        cancelButton.setOnAction(actionEvent -> {
            Const.showWindow(cancelButton, "authorization.fxml");
        });

    }
    public User getUser(){
        String password = String.valueOf(passwordField.getText().hashCode());
        String gender = "";
        String role = "";
        if (manRadioButton.isSelected())
            gender = "Мужской";
        else if (femaleRadioButton.isSelected())
            gender = "Женский";

        if (shopRadioButton.isSelected())
            role = "Работник магазина";
        else if (factoryRadioButton.isSelected())
            role = "Работник фабрики";
        User user = new User(firstNameField.getText(), lastNameField.getText(), loginField.getText(), password, gender, role);

        return user;
    }

}