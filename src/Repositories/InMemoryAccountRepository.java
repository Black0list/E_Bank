package Repositories;

import Entities.Account;
import Entities.User;
import RepositoriesIntf.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {
    List<Account> accounts = new ArrayList<Account>();

    public Account save(Account account){
        accounts.add(account);
        return account;
    }
}
