package Main;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.Scanner;

import Entities.Account;
import Entities.User;
import Repositories.InMemoryAccountRepository;
import Services.AccountService;
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

        int choice = 100;
        Scanner input = new Scanner(System.in);
        Display.menu();


        while(choice != 10){
            System.out.print("=======================================\nChoice (enter 9 to show menu) : ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("That wasn't a number.");
                input.next();
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
                    String name = input.next();
                    System.out.print("Email : ");
                    String email = input.next();
                    System.out.print("Password : ");
                    String password = input.next();
                    System.out.print("Address : ");
                    String address = input.next();

                    userService.register(name,email,password,address);
                    break;
                }

                case 2 : {
                    Display.clear();
                    System.out.println("=============================================");
                    System.out.println("                    Login                    ");
                    System.out.println("=============================================");
                    System.out.print("email : ");
                    String email = input.next();
                    System.out.print("Password : ");
                    String password = input.next();

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
                        if (input.hasNextInt()) {
                            choice = input.nextInt();
                        } else {
                            System.out.println("That wasn't a number.");
                            input.next();
                            continue;
                        }

                        switch (choice){
                            
                            case 1 : {
                                System.out.println(USER);
                                break;
                            }
                            
                            case 2 : {
                                System.out.print("Enter The New Mail : ");
                                input.nextLine();
                                String email = input.nextLine();
                                USER = userService.updateEmail(email);
                                System.out.println("Email Updated Successfully");
                                break;
                            }

                            case 3 : {
                                System.out.print("Enter The New Address : ");
                                input.nextLine();
                                String address = input.nextLine();
                                USER = userService.updateAddress(address);
                                System.out.println("Address Updated Successfully");
                                break;
                            }

                            case 4 : {
                                System.out.print("Confirm Password first : ");
                                input.nextLine();
                                String password = input.nextLine();
                                if(userService.checkPassword(password)){
                                    System.out.println("Correct Password !");
                                    System.out.print("Enter the new password : ");
                                    password = input.nextLine();
                                    USER = userService.updatePassword(password);
                                    System.out.println("Password Updated Successfully");
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
                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        System.out.println("That wasn't a number.");
                        input.next();
                        continue;
                    }
                        switch (choice){
                            case 1 : {
                                Display.clear();
                                Account account = accountService.create(USER);
                                System.out.println("Account Created Successfully");
                                System.out.println(account);
                                break;
                            }

                            case 9 : {
                                Display.bankMenu();
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