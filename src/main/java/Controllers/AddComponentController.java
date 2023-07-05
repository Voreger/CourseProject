package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddComponentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MyOrdersButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button checkSeriesButton;

    @FXML
    void initialize() {
        checkSeriesButton.setOnAction(actionEvent -> {
            Const.showWindow(checkSeriesButton, "checkSeries.fxml");
        });

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });
    }

}
