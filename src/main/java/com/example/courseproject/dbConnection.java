package com.example.courseproject;
import java.sql.*;
public class dbConnection {
    public dbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver" );
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://"+ Const.dbHost + ":" + Const.dbPort + "/" + Const.dbName,
                    Const.dbUser , Const.dbPassword);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Posts" ;
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                int id = result.getInt("id" );
                String name = result.getString("name" );
                String short_name = result.getString("short_name" );
                System.out.print(" Vacant post: " );
                System.out.print(" id = " + id);
                System.out.print(" , name = \"" + name + " \"" );
                System.out.println(" , short name = \"" + short_name + " \". " );
            }
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
