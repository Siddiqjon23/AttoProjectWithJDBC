package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtill {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/AttoProject", "user_db", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createUserTable(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE  if not exists USER_1(" +
                    "id serial primary key," +
                    "name varchar(250) not null," +
                    "surname varchar(250) not null," +
                    "phone varchar(250) not null," +
                    "password varchar(250) not null," +
                    "createdAt TIMESTAMP not null," +
                    "userStatus varchar(250) not null," +
                    "role varchar(25) not null" +
                    ")";

            String sql2 = "CREATE TABLE  if not exists Card(" +
                    "cardNumber varchar(250)  not null," +
                    "expiredDate varchar(50) not null," +
                    "balance decimal(10,2)not null," +
                    "status varchar(50)not null," +
                    "phone varchar(20)," +
                    "createdDate Date not null" +
                    ")";
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
