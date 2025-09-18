package Services;

import Entities.Account;
import Entities.User;
import RepositoriesIntf.AccountRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class AccountService {
    public AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }

    public void create(User user, Account.Type type){
        List<Account> accounts = accountRepo.all(user);
        Account account = accounts.stream()
                .filter(acc -> acc.getType() == type)
                .findFirst()
                .orElse(null);

        if(account != null){
            System.out.println("You already have an account with this Type : "+type);
        } else {
            account = new Account(user, type);
            this.accountRepo.save(account);
            System.out.println("Account Created Successfully");
        }
    }

    public void userAccounts(User user){
        List<Account> accounts = accountRepo.all(user);
        accounts.stream().forEach(account -> System.out.println(account));
        System.out.println("Total : "+accounts.toArray().length);
    }

    public void showAccount(String accountId){
        Account account = accountRepo.getById(accountId);
        if(account == null){
            System.out.println("Bad Account Id :-), retry!");
        } else {
            System.out.println("AccountId Number ("+account.getAccountId()+")'s SOLD is : "+account.getBalance()+"$");
        }
    }

    public void closeAccount(String accountId){
        Account account = accountRepo.getById(accountId);
        if(account == null){
            System.out.println("Bad Account Id :-), retry!");
        } else {
            if(Objects.equals(account.getBalance(), 0)){
                account.setActive(false);
                accountRepo.save(account);
                System.out.println("Account Closed Successfully");
            } else {
                System.out.println("You Still have Money in Your Account");
            }
        }
    }
}
