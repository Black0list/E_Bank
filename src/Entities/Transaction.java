package Entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;
import java.util.*;

public class Transaction {

    public enum Type {
        DEPOSIT,
        WITHDRAW,
        TRANSFER_IN,
        TRANSFER_OUT
    }

    private String id;
    private Instant timestamp;
    private Account account;
    private BigDecimal amount;
    private Type type;

    Random random = new Random();
    public Transaction(Account account, Type type,BigDecimal amount){
        this.id = "BK-"+ random.nextInt(9000) +"-"+random.nextInt(9000);;
        this.account = account;
        this.amount = amount;
        this.timestamp = timestamp;
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountId=" + account.getAccountId() +
                ", id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
