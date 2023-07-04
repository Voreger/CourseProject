package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FurnitureOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MyOrdersButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    void initialize() {
        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

    }

}
