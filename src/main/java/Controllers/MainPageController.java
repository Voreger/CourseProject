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
    private Button OrderFurnitureShopButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button addComponentFactoryButton;

    @FXML
    private Button checkSeriesFactoryButton;

    @FXML
    private Button exitButton;


    @FXML
    void initialize() {
        if (Const.user.getRole().equals("Работник магазина")){
            addComponentFactoryButton.setVisible(false);
            checkSeriesFactoryButton.setVisible(false);
        }
        else{
            OrderFurnitureShopButton.setVisible(false);
        }


        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        exitButton.setOnAction(actionEvent -> {
            Const.showWindow(exitButton, "authorization.fxml");
        });

        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });

        OrderFurnitureShopButton.setOnAction(actionEvent -> {
            Const.showWindow(OrderFurnitureShopButton, "furnitureOrder.fxml");
        });

        checkSeriesFactoryButton.setOnAction(actionEvent -> {
            Const.showWindow(checkSeriesFactoryButton, "checkSeries.fxml");
        });

        addComponentFactoryButton.setOnAction(actionEvent -> {
            Const.showWindow(addComponentFactoryButton, "addComponent.fxml");
        });

    }

}
