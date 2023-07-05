package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Const {
    public static final String dbPassword = "12345678";
    public static final String dbUser = "std_2261_furniture_factory";
    public static final String dbHost = "std-mysql.ist.mospolytech.ru";
    public static final String dbPort = "3306";
    public static final String dbName = "std_2261_furniture_factory";

    public static User user;



    /*"std-2261.ist.mospolytech.ru"*/
    public static void showWindow(Button button, String window){
        button.getScene().getWindow().hide();

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Const.class.getResource("/fxmlFiles/" + window));
        try {
            loader1.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader1.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Мебельная фабрика");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
