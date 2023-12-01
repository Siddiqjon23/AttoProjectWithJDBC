package Repositories;

import DTOs.User;
import Db.DbUtill;

import java.sql.*;
import java.time.LocalDateTime;

public class LoginAndRegistrationRepository {
    public Boolean Register(User user){
        boolean t = false;

        try {
            Connection connection = DbUtill.getConnection();

//          String sql = "insert into user_1(name,surname,phone,password,createdAt,userStatus,role)" +
//                  "values(?,?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2, user.getSurname());
//            preparedStatement.setString(3,user.getPhone());
//            preparedStatement.setString(4,user.getPassword());
//            preparedStatement.setString(5, String.valueOf(user.getCreatedAt()));
//            preparedStatement.setString(6, String.valueOf(user.getUserStatus()));
//            preparedStatement.setString(7, String.valueOf(user.getRole()));
//
//            preparedStatement.executeUpdate();

            String sql = "insert into user_1(name,surname,phone,password,createdAt,userStatus,role)" +
                    "values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(String.valueOf(user.getCreatedAt())));
            preparedStatement.setString(6, user.getUserStatus().toString());
            preparedStatement.setString(7, user.getRole().toString());

            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public User getUserByPhoneAndPassword(String phone, String password) {

        User user = new User();
        Connection connection = DbUtill.getConnection();
        String sql = "select phone,password from user_1 where phone = ? and password = ?";
        try {
           PreparedStatement preparedStatement =  connection.prepareStatement(sql);
           preparedStatement.setString(1,phone);
           preparedStatement.setString(2,password);
          ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
            user.setPhone(resultSet.getString("phone"));
            user.setPassword(resultSet.getString("password"));
           }else {
               return null;
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;

    }
}
