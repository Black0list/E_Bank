package Entities;

import java.time.Instant;
import java.util.UUID;
import java.math.BigDecimal;

public class Account {
    private String accountId;
    private UUID ownerUserId;
    private BigDecimal balance;
    private Instant createdAt;
    private boolean active;

    public Account(String accountId, UUID ownerUserId, BigDecimal balance, Instant createdAt, boolean active){
        this.accountId = accountId;
        this.ownerUserId = ownerUserId;
        this.balance = balance;
        this.createdAt = createdAt;
        this.active = active;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
