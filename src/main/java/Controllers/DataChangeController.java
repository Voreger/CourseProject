package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    void initialize() {
        CancelButton.setOnAction(actionEvent -> {
            CancelButton.getScene().getWindow().hide();

            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/fxmlFiles/personalCabinet.fxml"));
            try {
                loader1.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader1.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мебельная фабрика");
            stage.setScene(new Scene(root));
            stage.show();
        });

        SaveDataButton.setOnAction(actionEvent -> {
            SaveDataButton.getScene().getWindow().hide();

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
            stage.show();
        });

    }

}
