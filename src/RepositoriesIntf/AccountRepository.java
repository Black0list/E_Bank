package RepositoriesIntf;

import Entities.Account;
import Entities.User;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);
    List<Account> all(User user);
    Account getById(String accounId);
}
