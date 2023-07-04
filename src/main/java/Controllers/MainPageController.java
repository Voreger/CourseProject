package Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MyOrdersButton;

    @FXML
    private Button OrderFurnitureButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    void initialize() {
        PersonalCabinetButton.setOnAction(actionEvent -> {
            PersonalCabinetButton.getScene().getWindow().hide();

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

    }

}
