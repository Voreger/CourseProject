package Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.dbConnection;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

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
    private Button addFurnitureButton;

    @FXML
    private Text errorText;

    @FXML
    private TextField faxShopTextField;

    @FXML
    private TextField furnitureNameTextField;


    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        MyOrdersButton.setOnAction(actionEvent -> {
            Const.showWindow(MyOrdersButton, "myOrders.fxml");
        });

        PersonalCabinetButton.setOnAction(actionEvent -> {
            Const.showWindow(PersonalCabinetButton, "personalCabinet.fxml");
        });





        //обработка добавления мебели
        dbConnection dbConnect = new dbConnection();
        ArrayList<String> furnitureArray = new ArrayList<>();
        saveButton.setOnAction(actionEvent -> {
            if ((furnitureNameTextField.getText().isEmpty() && furnitureArray.isEmpty()) || faxShopTextField.getText().isEmpty()){
                errorText.setVisible(true);
            }
            else{
                if (!furnitureNameTextField.getText().isEmpty())
                    furnitureArray.add(dbConnect.getFurnitureId(furnitureNameTextField.getText()));
                dbConnect.addOrder(furnitureArray.size(), faxShopTextField.getText());

                for (int i = 0; i < furnitureArray.size(); i++) {
                    dbConnect.addFurniture(furnitureArray.get(i));
                }
                furnitureArray.clear();
                faxShopTextField.clear();
                furnitureNameTextField.clear();
            }
        });



        addFurnitureButton.setOnAction(actionEvent -> {
            if(!furnitureNameTextField.getText().isEmpty()){
                furnitureArray.add(dbConnect.getFurnitureId(furnitureNameTextField.getText()));
                furnitureNameTextField.clear();
            }

        });



    }

}
