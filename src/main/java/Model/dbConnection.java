package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbConnection {
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver" );
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://"+ Const.dbHost + ":" + Const.dbPort + "/" + Const.dbName,
                Const.dbUser , Const.dbPassword);

        return connection;
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO Users(login, password, first_name, second_name, gender, role) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, user.getLogin() );
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getRole());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet checkUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM Users WHERE login=? and password=?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, String.valueOf(user.getPassword().hashCode()));

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void updateUser(User user){
        String update = "UPDATE Users SET login=?, password=?, first_name=?, second_name=?, gender=?, role=? WHERE user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(update);

            preparedStatement.setString(1, user.getLogin() );
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setString(7, String.valueOf(Const.user.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addComponent(Component component){
        String insert =
                "INSERT INTO Component_type(type, price) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, component.getType());
            preparedStatement.setString(2, component.getPrice());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet resultSet = null;

        String select = "SELECT type_id FROM Component_type WHERE type=? and price=?";

        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = getDbConnection().prepareStatement(select);

            preparedStatement1.setString(1, component.getType());
            preparedStatement1.setString(2, component.getPrice());

            resultSet = preparedStatement1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String id = "";

        try {
            resultSet.next();
            id = resultSet.getString("type_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String insert1 =
                "INSERT INTO Component(type_id) VALUES (?)";
        PreparedStatement preparedStatement2 = null;
        try {
            preparedStatement2 = getDbConnection().prepareStatement(insert1);

            preparedStatement2.setString(1, id);


            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet checkOrder(String order){

        ResultSet resultSet = null;

        String select = "SELECT Furniture_type.type from Orders INNER join furniture_order USING(order_id) " +
                "inner join Furniture using(furniture_id) INNER JOIN Furniture_type using(furniture_id) where Orders.order_id = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            preparedStatement.setString(1, order);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public ResultSet allOrder(){
        ResultSet resultSet = null;

        String select = "SELECT Orders.order_id, Orders.date, Store.address, Users.first_name, Users.second_name from Orders inner join Store USING(store_id) inner join Users USING(user_id)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public ResultSet checkSeries(String name){
        ResultSet resultSet = null;

        String select = "SELECT Furniture_type.type from Series inner join Furniture_series USING(series_id) INNER JOIN Furniture USING(furniture_id) " +
                "INNER join Furniture_type USING(furniture_id) where Series.name = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public ResultSet allSeries(){

        ResultSet resultSet = null;

        String select = "SELECT name FROM Series";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public String getFurnitureId(String name){
        ResultSet resultSet = null;

        String select = "SELECT furniture_id from Furniture_type WHERE type = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String id = "";

        try {
            resultSet.next();
            id = resultSet.getString("furniture_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public void addOrder(int count, String fax){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(date);
        String furnitureCount = String.valueOf(count);
        String shopId="";
        String userId = String.valueOf(Const.user.getId());

        //Ищем ID магазина по факсу
        ResultSet resultSet = null;

        String select = "SELECT store_id from Store where fax=?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            preparedStatement.setString(1, fax);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet.next();
            shopId = resultSet.getString("store_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Добавляем заказ
        String insert =
                "INSERT INTO Orders(date, user_id, furniture_count, store_id) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = getDbConnection().prepareStatement(insert);

            preparedStatement1.setString(1, dateStr);
            preparedStatement1.setString(2, userId);
            preparedStatement1.setString(3, furnitureCount);
            preparedStatement1.setString(4, shopId);


            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void addFurniture(String id){
        //Находим id только что добавленного заказа
        ResultSet resultSet = null;

        String select = "SELECT order_id from Orders ORDER BY order_id DESC limit 1;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(select);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String orderId = "";

        try {
            resultSet.next();
            orderId = resultSet.getString("order_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        //Добавляем набор мебели
        String insert =
                "INSERT into furniture_order(furniture_id, order_id) VALUES(?,?)";
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = getDbConnection().prepareStatement(insert);

            preparedStatement1.setString(1, id);
            preparedStatement1.setString(2, orderId);


            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
