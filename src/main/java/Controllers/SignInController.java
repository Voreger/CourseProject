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
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUpButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField loginField2;

    @FXML
    private TextField loginField3;

    @FXML
    private RadioButton manRadioButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(actionEvent -> {
            SignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxmlFiles/authorization.fxml"));
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