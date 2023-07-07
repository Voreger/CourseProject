package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Order;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import Model.Const;
import Model.dbConnection;
import javafx.fxml.FXML;

public class MyOrdersController {


    @FXML
    private Button OrderFurnitureButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button addComponentFactoryButton;

    @FXML
    private TableColumn<Order, String> addressColumn;

    @FXML
    private Button checkSeriesFactoryButton;

    @FXML
    private TableColumn<Order, String> customerColumn;

    @FXML
    private TableColumn<Order, String> dateColumn;

    @FXML
    private TableColumn<Order, String> furnitureColumn;
    @FXML
    private Button mainPageButton;
    @FXML
    private Button furnitureCheckButton;
    @FXML
    private TableView<Order> ordersTable;

    ObservableList<Order> orderList = FXCollections.observableArrayList();

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
        mainPageButton.setOnAction(actionEvent -> {
            Const.showWindow(addComponentFactoryButton, "mainPage.fxml");
        });
        furnitureCheckButton.setOnAction(actionEvent -> {
            Const.showWindow(furnitureCheckButton, "furnitureCheck.fxml");
        });

        //Обработка отображения текущих заказов
        dbConnection dbConnect = new dbConnection();
        ResultSet orderSet = dbConnect.allOrder();

        furnitureColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("furniture"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("store"));

        ordersTable.setItems(orderList);

        try {
            while(orderSet.next()) {
                String name = orderSet.getString("first_name") + " " + orderSet.getString("second_name");
                String date = String.valueOf(orderSet.getDate("date"));
                String address = orderSet.getString("address");

                ResultSet orderFurnitureSet = dbConnect.checkOrder(String.valueOf(orderSet.getInt("order_id")));
                String orders = "";
                Boolean isFirst = true;
                while (orderFurnitureSet.next()) {
                    if (!isFirst)
                        orders+= ", ";
                    orders += orderFurnitureSet.getString("type");
                    isFirst = false;
                }
                Order order = new Order(name, date, address, orders);
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
