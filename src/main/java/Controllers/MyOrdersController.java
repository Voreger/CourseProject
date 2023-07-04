package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MyOrdersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OrderFurnitureButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    void initialize() {
        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        OrderFurnitureButton.setOnAction(actionEvent -> {
            Const.showWindow(OrderFurnitureButton, "furnitureOrder.fxml");
        });
    }

}
