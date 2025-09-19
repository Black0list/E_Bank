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

    public Account showAccount(String accountId){
        Account account = accountRepo.getById(accountId);
        if(account == null){
            System.out.println("Bad Account Id :-), retry!");
        } else {
            System.out.println("AccountId Number ("+account.getAccountId()+")'s SOLD is : "+account.getBalance()+"$");
            return account;
        }

        return account;
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

    public void deposit(Account account, BigDecimal amount){
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Invalide Amount");
        } else {
            account.setBalance(account.getBalance().add(amount));
            accountRepo.save(account);
            System.out.println("Successfully Deposited "+amount+"$ in Your Account Number ("+account.getAccountId()+")");
        }
    }

    public void withdraw(Account account, BigDecimal amount){
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Invalide Amount");
        } else if(account.getBalance().compareTo(amount) < 0){
            System.out.println("Insufficient Funds, You have Only : "+account.getBalance()+"$");
        } else {
            account.setBalance(account.getBalance().subtract(amount));
            accountRepo.save(account);
            System.out.println("Successfully WithDraw "+amount+"$ from Your Account Number ("+account.getAccountId()+")");
        }
    }

    public void transferOUT(Account sender, BigDecimal amount){
        sender.setBalance(sender.getBalance().subtract(amount));
        accountRepo.save(sender);
        System.out.println("Successfully sent "+amount+"$ to the account you provided");
    }

    public void transferIN(Account receiver, BigDecimal amount){
        receiver.setBalance(receiver.getBalance().add(amount));
        accountRepo.save(receiver);
        System.out.println("Successfully received "+amount+"$");
    }
}
