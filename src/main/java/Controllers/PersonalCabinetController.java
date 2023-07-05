package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PersonalCabinetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DataChangeButton;

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
        firstNameTextField.setText(Const.user.getFirstName());
        secondNameTextField.setText(Const.user.getSecondName());
        loginTextField.setText(Const.user.getLogin());
        genderTextField.setText(Const.user.getGender());

        mainPageButton.setOnAction(actionEvent -> {
            Const.showWindow(mainPageButton, "mainPage.fxml");
        });

        DataChangeButton.setOnAction(actionEvent -> {
            Const.showWindow(DataChangeButton, "dataChange.fxml");
        });
    }

}
