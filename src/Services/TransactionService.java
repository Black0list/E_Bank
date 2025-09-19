package Services;

import Entities.Account;
import Entities.Transaction;
import Repositories.InMemoryAccountRepository;
import RepositoriesIntf.AccountRepository;
import RepositoriesIntf.TransactionRepository;

import java.math.BigDecimal;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private TransactionRepository transacionRepo;
    private AccountService accountService;

    public TransactionService(TransactionRepository transacionRepo, AccountRepository accountRepo){
        this.transacionRepo = transacionRepo;
        this.accountService = new AccountService(accountRepo);
    }

    public void recordDeposit(Account account, BigDecimal amount){
        Transaction transaction = new Transaction(account, Transaction.Type.DEPOSIT, amount);
        accountService.deposit(account, amount);
        transacionRepo.save(transaction);
    }

    public void recordWithdraw(Account account, BigDecimal amount){
        Transaction transaction = new Transaction(account, Transaction.Type.WITHDRAW, amount);
        accountService.withdraw(account, amount);
        transacionRepo.save(transaction);
    }

    public void recordTransfer(String senderId, String receiverId, BigDecimal amount) {
        Account sender = accountService.accountRepo.getById(senderId);
        Account receiver = accountService.accountRepo.getById(receiverId);

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Invalid Amount");
            return;
        }

        if (sender != null && !sender.isActive()) {
            System.out.println("Your account is not active");
            return;
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient Funds, You have Only : " + sender.getBalance() + "$");
            return;
        }

        if (receiver != null) {
            Transaction transactionOut = new Transaction(sender, Transaction.Type.TRANSFER_OUT, amount);
            Transaction transactionIn = new Transaction(receiver, Transaction.Type.TRANSFER_IN, amount);

            accountService.transferOUT(sender, amount);
            accountService.transferIN(receiver, amount);

            transacionRepo.save(transactionOut);
            transacionRepo.save(transactionIn);
        }

        else if (receiver == null) {
            Transaction transactionOut = new Transaction(sender, Transaction.Type.TRANSFER_OUT, amount);
            accountService.transferOUT(sender, amount);
            transacionRepo.save(transactionOut);
        }

        else {
            System.out.println("Receiver account is not active");
        }
    }


    public void history(Account account){
        List<Transaction> transactions = transacionRepo.allByAccountId(account.getAccountId());

        transactions.stream()
                .filter(transaction -> transaction.getAccount().getAccountId().equals(account.getAccountId()))
                .forEach(transac -> System.out.println(transac));
    }
}
