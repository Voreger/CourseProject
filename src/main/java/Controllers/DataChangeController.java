package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import Model.User;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class DataChangeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CancelButton;

    @FXML
    private RadioButton FemaleRadioButton;

    @FXML
    private TextField FirstNameTextField;

    @FXML
    private ToggleGroup Group;

    @FXML
    private TextField LoginTextField;

    @FXML
    private RadioButton MaleRadioButton;

    @FXML
    private PasswordField NewPasswordTextField;

    @FXML
    private PasswordField OldPasswordTextField;

    @FXML
    private Button SaveDataButton;

    @FXML
    private TextField SecondNameTextField;

    @FXML
    private RadioButton factoryRadioButton;

    @FXML
    private RadioButton shopRadioButton;
    @FXML
    private Text errorText;


    @FXML
    void initialize() {
        dbConnection dbConnect = new dbConnection();
        CancelButton.setOnAction(actionEvent -> {
            Const.showWindow(CancelButton, "personalCabinet.fxml");
        });

        SaveDataButton.setOnAction(actionEvent -> {
            if(String.valueOf(OldPasswordTextField.getText().hashCode()).equals(Const.user.getPassword()) && !NewPasswordTextField.getText().isEmpty() &&
                    !OldPasswordTextField.getText().isEmpty() && !FirstNameTextField.getText().isEmpty() && !SecondNameTextField.getText().isEmpty() && !LoginTextField.getText().isEmpty()) {
                String password = String.valueOf(NewPasswordTextField.getText().hashCode());
                String gender = "";
                String role = "";

                if (MaleRadioButton.isSelected())
                    gender = "Мужской";
                else if (FemaleRadioButton.isSelected())
                    gender = "Женский";

                if (shopRadioButton.isSelected())
                    role = "Работник магазина";
                else if (factoryRadioButton.isSelected())
                    role = "Работник фабрики";

                User user = new User(FirstNameTextField.getText(), SecondNameTextField.getText(), LoginTextField.getText(), password, gender, role);

                dbConnect.updateUser(user);

                Const.showWindow(SaveDataButton, "authorization.fxml");
            } else {
                errorText.setVisible(true);
            }
        });

    }

}
