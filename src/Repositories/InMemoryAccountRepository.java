package Repositories;

import Entities.Account;
import Entities.User;
import RepositoriesIntf.AccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InMemoryAccountRepository implements AccountRepository {
    List<Account> accounts = new ArrayList<Account>();

    public Account save(Account account){
        Account accFound = accounts.stream()
                .filter(acc -> Objects.equals(acc.getAccountId(), account.getAccountId()))
                .findFirst()
                .orElse(null);

        if(accounts.remove(accFound)){
            accounts.add(account);
        } else {
            accounts.add(account);
        }

        return account;
    }

    public List<Account> all(User user){
        return accounts.stream()
                .filter(acc -> Objects.equals(user, acc.getOwnerUser()))
                .toList();
    }

    public Account getById(String accountId){
        return accounts.stream()
                .filter(acc -> Objects.equals(acc.getAccountId(), accountId))
                .findFirst()
                .orElse(null);
    }
}
