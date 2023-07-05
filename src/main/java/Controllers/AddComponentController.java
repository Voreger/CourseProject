package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Const;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddComponentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text ErrorText;

    @FXML
    private Button MyOrdersButton;

    @FXML
    private Button saveComponentButton;

    @FXML
    private Button PersonalCabinetButton;

    @FXML
    private Button checkSeriesButton;

    @FXML
    private TextField componentNameTextField;

    @FXML
    private TextField componentPriceTextField;
    @FXML
    void initialize() {
        dbConnection dbConnect = new dbConnection();


        //Обработка кнопок меню
        checkSeriesButton.setOnAction(actionEvent -> {
            Const.showWindow(checkSeriesButton, "checkSeries.fxml");
        });

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });

        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });


        //обработка добавления
        saveComponentButton.setOnAction(actionEvent -> {
            if(componentNameTextField.getText().isEmpty() || componentPriceTextField.getText().isEmpty())
                ErrorText.setVisible(true);
            else{
                dbConnect.addComponent(componentNameTextField.getText(), componentPriceTextField.getText());
                componentPriceTextField.clear();
                componentNameTextField.clear();
            }
        });


    }

}
