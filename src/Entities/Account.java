package Entities;

import java.math.RoundingMode;
import java.time.Instant;
import java.util.UUID;
import java.util.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.logging.Level;



public class Account {

    public enum Type {
        STANDARD,
        CREDIT,
        SAVINGS
    }

    private String accountId;
    private User ownerUser;
    private BigDecimal balance;
    private Instant createdAt;
    private boolean active;
    private Type type;

    Random random = new Random();
    public Account(User user, Type type){
        this.accountId = "BK-"+ random.nextInt(9000) +"-"+random.nextInt(9000);
        this.ownerUser = user;
        this.balance = new BigDecimal(10).setScale(2, RoundingMode.HALF_DOWN);
        this.createdAt = Instant.now();
        this.active = true;
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public Random getRandom() {
        return random;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", active=" + active +
                ", type=" + type +
                '}';
    }
}
