//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.UUID;

import Entities.User;
import RepositoriesIntf.UserRepository;
import Services.UserService;
import Repositories.InMemoryUserRepository;

public class Main {
    public static void main(String[] args) {

//      Services
        UserService userService = new UserService(new InMemoryUserRepository());

        int choice = 0;
        Scanner input = new Scanner(System.in);

        while(choice != 4){
        System.out.println("================  Menu  ================");
        System.out.println("1. Register");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("That wasn't a number.");
                input.next();
                continue;
            }

            switch (choice) {
                case 1 : {
                    System.out.print("Fullname : ");
                    String name = input.next();
                    System.out.print("Email : ");
                    String email = input.next();
                    System.out.print("Password");
                    String password = input.next();
                    System.out.print("Address : ");
                    String address = input.next();

                    userService.register(name,email,password,address);
                    System.out.println(userService.all());
                }
            }

        }
    }
}