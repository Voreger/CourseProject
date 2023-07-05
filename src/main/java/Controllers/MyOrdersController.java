package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.User;
import javafx.scene.text.Text;

import Model.Const;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MyOrdersController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NextOrderButton;

    @FXML
    private Button OrderFurnitureButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button addComponentFactoryButton;

    @FXML
    private Button checkSeriesFactoryButton;

    @FXML
    private Text orderDateText;

    @FXML
    private Text orderFurnitureText;

    @FXML
    private Text shopAddressText;

    @FXML
    private Text userNameText;
    @FXML
    void initialize() {

        //Обработка кнопок меню
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

        //Обработка отображения текущих заказов
        dbConnection dbConnect = new dbConnection();
        ResultSet orderSet = dbConnect.allOrder();

        String Orders = "";
        int count = 1;
        try {
            orderSet.next();
            orderDateText.setText(String.valueOf(orderSet.getDate("date")));
            shopAddressText.setText(orderSet.getString("address"));
            userNameText.setText(orderSet.getString("first_name") + " " + orderSet.getString("second_name"));
            ResultSet orderFurnitureSet = dbConnect.checkOrder(String.valueOf(orderSet.getInt("order_id")));
            while (orderFurnitureSet.next()) {
                Orders += count + ") " + orderFurnitureSet.getString("type") + "\n";
                count++;
            }
            orderFurnitureText.setText(Orders);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        NextOrderButton.setOnAction(actionEvent -> {
            try {
                int count1 = 1;
                orderSet.next();
                if(orderSet.isLast())
                    NextOrderButton.setVisible(false);
                orderDateText.setText(String.valueOf(orderSet.getDate("date")));
                shopAddressText.setText(orderSet.getString("address"));
                userNameText.setText(orderSet.getString("first_name") + " " + orderSet.getString("second_name"));
                String Orders1 = "";
                ResultSet orderFurnitureSet = dbConnect.checkOrder(String.valueOf(orderSet.getInt("order_id")));
                while (orderFurnitureSet.next()) {
                    Orders1 += count1 + ") " + orderFurnitureSet.getString("type") + "\n";
                    count1++;
                }
                orderFurnitureText.setText(Orders1);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
