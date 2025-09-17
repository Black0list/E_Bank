package Entities;

import java.time.Instant;
import java.util.UUID;
import java.util.*;
import java.math.BigDecimal;
import java.time.Instant;

public class Account {
    private String accountId;
    private User ownerUser;
    private BigDecimal balance;
    private Instant createdAt;
    private boolean active;

    Random random = new Random();
    public Account(User user){
        this.accountId = "BK-"+ random.nextInt(1000) +"-"+random.nextInt(1000);
        this.ownerUser = user;
        this.balance = new BigDecimal(0);
        this.createdAt = Instant.now();
        this.active = true;
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

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", ownerUser=" + ownerUser.getEmail() +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", active=" + active +
                '}';
    }
}
