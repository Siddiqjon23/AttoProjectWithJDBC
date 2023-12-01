package DTOs;

import Enums.CardStatus;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class CardDTO {
    // number,exp_date,balance,status,phone,created_date
    private String cardNumber;
    private String expiredDate;
    private Double balance;
    private CardStatus status;
    private String phone;
    private LocalDateTime createdAt;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "cardNumber=" + cardNumber +
                ", expiredDate=" + expiredDate +
                ", balance=" + balance +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
