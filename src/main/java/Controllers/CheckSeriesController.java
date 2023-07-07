package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Const;
import Model.Order;
import Model.dbConnection;
import Model.furnitureSeries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class CheckSeriesController {


    @FXML
    private Button MyOrdersButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button addComponentButton;

    @FXML
    private TableColumn<furnitureSeries, String> furnitureColumn;

    @FXML
    private TableColumn<furnitureSeries, String> nameColumn;
    @FXML
    private Button mainPageButton;

    @FXML
    private Button furnitureCheckButton;

    @FXML
    private TableView<furnitureSeries> seriesTable;

    ObservableList<furnitureSeries> seriesList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        //Реализация кнопок меню
        addComponentButton.setOnAction(actionEvent -> {
            Const.showWindow(addComponentButton, "addComponent.fxml");
        });

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });
        mainPageButton.setOnAction(actionEvent -> {
            Const.showWindow(mainPageButton, "mainPage.fxml");
        });
        furnitureCheckButton.setOnAction(actionEvent -> {
            Const.showWindow(furnitureCheckButton, "furnitureCheck.fxml");
        });

        //Реализация отображения линеек
        dbConnection dbConnect = new dbConnection();
        ResultSet seriesNameSet = dbConnect.allSeries();

        furnitureColumn.setCellValueFactory(new PropertyValueFactory<furnitureSeries, String>("furniture"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<furnitureSeries, String>("name"));

        seriesTable.setItems(seriesList);


        try {
            while(seriesNameSet.next()) {
                String name = seriesNameSet.getString("name");

                ResultSet furnitureSeriesSet = dbConnect.checkSeries(name);
                String furnitureSeries = "";
                Boolean isFirst = true;
                while (furnitureSeriesSet.next()) {
                    if (!isFirst)
                        furnitureSeries += ", ";
                    furnitureSeries += furnitureSeriesSet.getString("type");
                    isFirst = false;
                }
                seriesList.add(new furnitureSeries(furnitureSeries, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
