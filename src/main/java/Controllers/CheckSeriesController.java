package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Const;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CheckSeriesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MyOrdersButton;

    @FXML
    private Text NameSeriesText;

    @FXML
    private Button NextSeriesButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Text SeriesText;

    @FXML
    private Button addComponentButton;

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

        //Реализация отображения линеек
        dbConnection dbConnect = new dbConnection();
        ResultSet seriesNameSet = dbConnect.allSeries();

        String furnitureSeries = "";
        int count = 1;
        try {
            seriesNameSet.next();
            NameSeriesText.setText(seriesNameSet.getString("name"));
            ResultSet furnitureSeriesSet = dbConnect.checkSeries(seriesNameSet.getString("name"));
            while (furnitureSeriesSet.next()) {
                furnitureSeries += count + ") " + furnitureSeriesSet.getString("type") + "\n";
                count++;
            }
            SeriesText.setText(furnitureSeries);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        NextSeriesButton.setOnAction(actionEvent -> {
            try {
                int count1 = 1;
                seriesNameSet.next();
                if(seriesNameSet.isLast())
                    NextSeriesButton.setVisible(false);
                NameSeriesText.setText(seriesNameSet.getString("name"));
                String furnitureSeries1 = "";
                ResultSet furnitureSeriesSet = dbConnect.checkSeries(seriesNameSet.getString("name"));
                while (furnitureSeriesSet.next()) {
                    furnitureSeries1 += count1 + ") " + furnitureSeriesSet.getString("type") + "\n";
                    count1++;
                }
                SeriesText.setText(furnitureSeries1);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
