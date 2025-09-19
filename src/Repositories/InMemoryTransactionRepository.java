package Repositories;

import Entities.Transaction;
import RepositoriesIntf.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {

    List<Transaction> transactions = new ArrayList<Transaction>();

    public void save(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> allByAccountId(String accountId){
        return transactions.stream()
                .filter(transaction -> transaction.getAccount().getAccountId().equals(accountId))
                .toList();
    }
}
