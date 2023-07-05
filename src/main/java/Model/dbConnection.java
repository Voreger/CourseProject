package Model;

import java.sql.*;
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

    public void addComponent(String type, String price){
        String insert =
                "INSERT INTO Component_type(type, price) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, type);
            preparedStatement.setString(2, price);


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

            preparedStatement1.setString(1, type);
            preparedStatement1.setString(2, price);

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
    public ResultSet checkOrder(){
        ResultSet resultSet = null;
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
}
