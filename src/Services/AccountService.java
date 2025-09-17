package Services;

import Entities.Account;
import Entities.User;
import RepositoriesIntf.AccountRepository;

public class AccountService {
    public AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }

    public Account create(User user){
        Account account = new Account(user);
        this.accountRepo.save(account);
        return account;
    }
}
