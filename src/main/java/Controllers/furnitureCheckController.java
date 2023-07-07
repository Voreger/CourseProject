package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class furnitureCheckController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OrderFurnitureButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button addComponentFactoryButton;

    @FXML
    private Button checkSeriesFactoryButton;


    @FXML
    private Button myOrdersButton;

    @FXML
    private Button mainPageButton;

    @FXML
    void initialize() {
        if (Const.user.getRole().equals("Работник магазина")){
            addComponentFactoryButton.setVisible(false);
            checkSeriesFactoryButton.setVisible(false);
        }
        else{
            OrderFurnitureButton.setVisible(false);
        }

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        OrderFurnitureButton.setOnAction(actionEvent -> {
            Const.showWindow(OrderFurnitureButton, "furnitureOrder.fxml");
        });

        checkSeriesFactoryButton.setOnAction(actionEvent -> {
            Const.showWindow(checkSeriesFactoryButton, "checkSeries.fxml");
        });

        addComponentFactoryButton.setOnAction(actionEvent -> {
            Const.showWindow(addComponentFactoryButton, "addComponent.fxml");
        });
        mainPageButton.setOnAction(actionEvent -> {
            Const.showWindow(addComponentFactoryButton, "mainPage.fxml");
        });
        myOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(myOrdersButton,"myOrders.fxml");
        });

    }

}
