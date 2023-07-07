package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Const;
import Model.dbConnection;
import Model.Furniture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Furniture, String> furnitureComponentsColumn;

    @FXML
    private TableColumn<Furniture, String> furniturePriceColumn;

    @FXML
    private TableView<Furniture> furnitureTable;

    @FXML
    private TableColumn<Furniture, String> furnitureTypeColumn;

    @FXML
    private Button myOrdersButton;

    @FXML
    private Button mainPageButton;
    ObservableList<Furniture> furnitureList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        //кнопки меню
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

        //отображение мебели
        dbConnection dbConnect = new dbConnection();
        ResultSet furnitureSet = dbConnect.allFurniture();

        furnitureTypeColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("type"));
        furniturePriceColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("price"));
        furnitureComponentsColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("component"));

        furnitureTable.setItems(furnitureList);

        try {
            while(furnitureSet.next()) {
                String price = String.valueOf(furnitureSet.getInt("price"));
                String type = furnitureSet.getString("type");

                ResultSet furnitureComponentSet = dbConnect.checkFurniture(String.valueOf(furnitureSet.getInt("furniture_id")));
                String components = "";
                Boolean isFirst = true;
                while (furnitureComponentSet.next()) {
                    if (!isFirst)
                        components += ", ";
                    components += furnitureComponentSet.getString("type");
                    isFirst = false;
                }
                Furniture furniture = new Furniture(type, components, price);
                furnitureList.add(furniture);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
