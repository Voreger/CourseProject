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
import javafx.scene.image.ImageView;
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
    private Button exitButton;

    @FXML
    void initialize() {
        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        exitButton.setOnAction(actionEvent -> {
            Const.showWindow(exitButton, "authorization.fxml");
        });

    }

}
