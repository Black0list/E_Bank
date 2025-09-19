package RepositoriesIntf;

import Entities.Account;
import Entities.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> allByAccountId(String accountId);
}
