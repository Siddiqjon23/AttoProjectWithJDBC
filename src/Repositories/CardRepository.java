package Repositories;

import DTOs.CardDTO;
import Db.DbUtill;
import Enums.CardStatus;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CardRepository {
    public Boolean add(CardDTO cardDTO){
        boolean bool = false;
        Connection connection = DbUtill.getConnection();
        String sql = "insert into card(cardNumber,expiredDate,balance,status,phone,createdDate) values(?,?,?,?,?,?)";
        try {
           PreparedStatement preparedStatement =  connection.prepareStatement(sql);
           preparedStatement.setString(1,cardDTO.getCardNumber());
           preparedStatement.setString(2,(cardDTO.getExpiredDate()));
           preparedStatement.setDouble(3,cardDTO.getBalance());
           preparedStatement.setString(4,String.valueOf(CardStatus.Blocked));
           preparedStatement.setString(5,cardDTO.getPhone());
           preparedStatement.setTimestamp(6, Timestamp.valueOf(cardDTO.getCreatedAt()));
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;

    }

    public List<CardDTO> getAllCards() {
        List<CardDTO> allCards = new LinkedList<>();
        Connection connection = DbUtill.getConnection();
        String sql = "select * from card";
        try {
           PreparedStatement preparedStatement =  connection.prepareStatement(sql);
          ResultSet resultSet =   preparedStatement.executeQuery();
         while (resultSet.next()){
             CardDTO cardDTO = new CardDTO();
             cardDTO.setCardNumber(resultSet.getString("cardNumber"));
             cardDTO.setExpiredDate(resultSet.getString("expiredDate"));
             cardDTO.setBalance(resultSet.getDouble("balance"));
             cardDTO.setStatus(CardStatus.valueOf(resultSet.getString("status")));
             cardDTO.setPhone(resultSet.getString("phone"));
             cardDTO.setCreatedAt(resultSet.getTimestamp("createdDate").toLocalDateTime());

             allCards.add(cardDTO);
             connection.close();
         }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCards;

    }

    public Boolean changeStatus(String cardNumber) {

        Connection connection = DbUtill.getConnection();
        String sql = "update card set status = ? where cardNumber = ?";
        try {
           PreparedStatement preparedStatement  =  connection.prepareStatement(sql);
           preparedStatement.setString(1, String.valueOf(CardStatus.Active));
           preparedStatement.setString(2,cardNumber);
           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Boolean deleteCard(String cardNumber, String expiredDate) {
        Connection connection = DbUtill.getConnection();
        String sql = "delete  from card  where cardNumber = ? and expiredDate = ?";
        try {
           PreparedStatement preparedStatement =  connection.prepareStatement(sql);
           preparedStatement.setString(1,cardNumber);
           preparedStatement.setString(2,expiredDate);
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Boolean addToBalance(String cardNumber, Double money) {

        Connection connection = DbUtill.getConnection();
        String sql = "update card set balance = ? where cardNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,money);
            preparedStatement.setString(2,cardNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
