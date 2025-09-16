package Entities;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private Instant timestamp;
    private String accountId;

    public Transaction(UUID id, Instant timestamp, String accountId){
        this.id = id;
        this.accountId = accountId;
        this.timestamp = timestamp;
    }
}
