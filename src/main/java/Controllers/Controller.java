package Controllers;

import Model.Const;
import Model.User;
import Model.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorText;
    @FXML
    void initialize(){
        SignInButton.setOnAction(actionEvent -> {
                loginUser();

        });
        SignUpButton.setOnAction(actionEvent -> {
            Const.showWindow(SignUpButton, "signIn.fxml");
        });
    }
    public void loginUser(){
        dbConnection dbConnect = new dbConnection();
        User user = new User();
        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());
        ResultSet resultSet = dbConnect.checkUser(user);
        int count = 0;

        String firstName = "";
        String secondName = "";
        String login = "";
        String password = "";
        String gender = "";
        String role = "";
        int id = 0;


        try {
            while (resultSet.next()) {
                count++;
                id = resultSet.getInt("user_id");
                firstName = resultSet.getString("first_name");
                secondName = resultSet.getString("second_name");
                login = resultSet.getString("login");
                password =  resultSet.getString("password");
                gender = resultSet.getString("gender");
                role = resultSet.getString("role");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if (count>=1){
            Const.user = new User(firstName,secondName, login, password, gender, role);
            Const.user.setId(id);

            Const.showWindow(SignInButton, "mainPage.fxml");
        } else {
            errorText.setVisible(true);
        }
    }

}
