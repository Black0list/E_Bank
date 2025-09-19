package Main;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Scanner;

import Entities.Account;
import Entities.User;
import Repositories.InMemoryAccountRepository;
import Repositories.InMemoryTransactionRepository;
import RepositoriesIntf.TransactionRepository;
import Services.AccountService;
import Services.TransactionService;
import Services.UserService;
import Repositories.InMemoryUserRepository;
import Utils.Validation;
import Utils.Display;

public class Main {
    public static User USER = null;
    public static void main(String[] args) {

        //Services
        UserService userService = new UserService(new InMemoryUserRepository());
        AccountService accountService = new AccountService(new InMemoryAccountRepository());
        TransactionService transactService = new TransactionService(new InMemoryTransactionRepository());

        int choice = 100;
        Scanner input = new Scanner(System.in);
        Display.menu();


        while(choice != 10){
            System.out.print("=======================================\nChoice (enter 9 to show menu) : ");
            String line = input.nextLine();
            try {
                choice = Integer.parseInt(line); // parse string to int
            } catch (NumberFormatException e) {
                System.out.println("That wasn't a number.");
                continue;
            }

            switch (choice) {

                case 0 : {
                    System.out.println("=============================");
                    System.out.println("         Good Bye :-)        ");
                    System.out.println("=============================");
                    return;
                }

                case 1 : {
                    Display.clear();
                    System.out.println("=============================================");
                    System.out.println("                 Registration                ");
                    System.out.println("=============================================");
                    System.out.print("Fullname : ");
                    String name = input.nextLine();
                    System.out.print("Email : ");
                    String email = input.nextLine();
                    System.out.print("Password : ");
                    String password = input.nextLine();
                    System.out.print("Address : ");
                    String address = input.nextLine();

                    userService.register(name,email,password,address);
                    break;
                }

                case 2 : {
                    Display.clear();
                    System.out.println("=============================================");
                    System.out.println("                    Login                    ");
                    System.out.println("=============================================");
                    System.out.print("email : ");
                    String email = input.nextLine();
                    System.out.print("Password : ");
                    String password = input.nextLine();

                    USER = userService.login(email,password);
                    if(Objects.isNull(USER)){
                        System.out.println("Identifiants Invalides");
                    }
                    break;
                }

                case 3 : {
                    USER = null;
                    Display.clear();
                    System.out.println("=============================================");
                    System.out.println("                Disconnected                 ");
                    System.out.println("=============================================");
                    break;
                }

                case 4 : {
                    if(!Validation.AuthCheck())
                    {
                        System.out.println("You're not authenticated");
                        break;
                    }
                    boolean running = true;
                    Display.profileMenu();
                    do{
                        System.out.print("=======================================\nChoice (enter 9 to show menu) : ");
                        line = input.nextLine();
                        try {
                            choice = Integer.parseInt(line); // parse string to int
                        } catch (NumberFormatException e) {
                            System.out.println("That wasn't a number.");
                            continue;
                        }

                        switch (choice){
                            
                            case 1 : {
                                System.out.println(USER);
                                break;
                            }
                            
                            case 2 : {
                                System.out.print("Enter The New Mail : ");
                                String email = input.nextLine();
                                USER = userService.updateEmail(email);
                                break;
                            }

                            case 3 : {
                                System.out.print("Enter The New Address : ");
                                String address = input.nextLine();
                                USER = userService.updateAddress(address);
                                break;
                            }

                            case 4 : {
                                System.out.print("Confirm Password first : ");
                                String password = input.nextLine();
                                if(userService.checkPassword(password)){
                                    System.out.println("Correct Password !");
                                    System.out.print("Enter the new password : ");
                                    password = input.nextLine();
                                    USER = userService.updatePassword(password);
                                } else {
                                    System.out.println("Incorrect password, retry !");
                                }
                                break;
                            }

                            case 5 : {
                                Display.menu();
                                running = false;
                                break;
                            }

                            case 6 : {

                            }

                            case 9 : {
                                Display.profileMenu();
                                break;
                            }
                        }
                    }while(running);
                    break;
                }

                case 5 : {
                    boolean running = true;
                    Display.bankMenu();
                    do{
                    System.out.print("=======================================\nChoice (enter 9 to show menu) : ");
                        line = input.nextLine();
                        try {
                            choice = Integer.parseInt(line); // parse string to int
                        } catch (NumberFormatException e) {
                            System.out.println("That wasn't a number.");
                            continue;
                        }
                        switch (choice){
                            case 1 : {
                                Display.TypeBankMenu();
                                System.out.print("=======================================\nChoice (enter 9 to show menu) : ");
                                line = input.nextLine();
                                choice = Integer.parseInt(line);
                                switch (choice){
                                    case 1 : {
                                        accountService.create(USER,Account.Type.STANDARD);
                                        break;
                                    }

                                    case 2 : {
                                        accountService.create(USER,Account.Type.CREDIT);
                                        break;
                                    }

                                    case 3 : {
                                        accountService.create(USER,Account.Type.SAVINGS);
                                        break;
                                    }

                                    case 4 : {
                                        System.out.println("Operation Cancelled!");
                                        break;
                                    }

                                    default: {
                                        System.out.println("Default!");
                                        accountService.create(USER,Account.Type.STANDARD);
                                        break;
                                    }
                                }
                                break;
                            }

                            case 2 : {
                                Display.clear();
                                System.out.println("=============================================");
                                System.out.println("                    Accounts                 ");
                                System.out.println("=============================================");
                                accountService.userAccounts(USER);
                                break;
                            }

                            case 3 : {
                                Display.clear();
                                System.out.print("What is the accountId : ");
                                String accountId = input.nextLine();
                                accountService.showAccount(accountId);
                                break;
                            }

                            case 4 : {
                                Display.clear();
                                System.out.print("What is the accountId You Want to Close : ");
                                String accountId = input.nextLine();
                                accountService.closeAccount(accountId);
                                break;
                            }

                            case 5 : {
                                Display.clear();
                                accountService.userAccounts(USER);
                                System.out.print("enter the accountId you want to deposit to : ");
                                line = input.nextLine();
                                Account account = accountService.showAccount(line);
                                if(account == null){
                                    System.out.println("Account Not Found");
                                    break;
                                }
                                System.out.print("Enter amount you want to deposit : ");
                                BigDecimal amount = input.nextBigDecimal().setScale(2, RoundingMode.HALF_DOWN);
                                transactService.recordDeposit(account,  amount);
                                input.nextLine();
                                break;
                            }

                            case 6 : {
                                Display.clear();
                                accountService.userAccounts(USER);
                                System.out.print("enter the accountId you want to withdraw from : ");
                                line = input.nextLine();
                                Account account = accountService.showAccount(line);
                                if(account == null){
                                    System.out.println("Account Not Found");
                                    break;
                                }
                                System.out.print("Enter amount you want to withdraw : ");
                                BigDecimal amount = input.nextBigDecimal().setScale(2, RoundingMode.HALF_DOWN);
                                transactService.recordWithdraw(account,  amount);
                                input.nextLine();
                                break;
                            }

                            case 7 : {
                                Display.clear();
                                accountService.userAccounts(USER);
                                System.out.print("enter the accountId you want to list its History : ");
                                line = input.nextLine();
                                Account account = accountService.showAccount(line);
                                if(account == null){
                                    System.out.println("Account Not Found");
                                    break;
                                }
                                transactService.history(account);
                                break;
                            }

                            case 8 : {
                                Display.bankMenu();
                                accountService.userAccounts(USER);
                                System.out.print("enter the accountId you want to transfer  money from : ");
                                String senderId = input.nextLine();
                                System.out.print("enter the accountId of the receiver's account : ");
                                String receiverId = input.nextLine();
                                System.out.print("Enter amount you want to send : ");
                                BigDecimal amount = input.nextBigDecimal().setScale(2, RoundingMode.HALF_DOWN);
                                input.nextLine();
                                transactService.recordTransfer(senderId, receiverId, amount);
                                break;
                            }

                            case 9 : {
                                break;
                            }
                        }

                    }while(running);
                    break;
                }

                case 9 : {
                    Display.clear();
                    Display.menu();
                    break;
                }

                case 10 : {
                    return;
                }
            }

        }
    }
}