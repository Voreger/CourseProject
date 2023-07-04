package Model;

import java.sql.*;
public class dbConnection {
    public dbConnection(){
    }
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

            preparedStatement.setString(1, user.login );
            preparedStatement.setString(2, user.password);
            preparedStatement.setString(3, user.firstName);
            preparedStatement.setString(4, user.secondName);
            preparedStatement.setString(5, user.gender);
            preparedStatement.setString(6, user.role);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
