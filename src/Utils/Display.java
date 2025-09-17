package Utils;

public class Display {
    public static void menu(){
        Display.clear();
        System.out.println("================  Menu  ================");
        System.out.println("0. Exit");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Disconnect");
        System.out.println("4. Edit Profile");
        System.out.println("5. Show Banking Menu");
        System.out.println("9. Menu");
    }

    public static void profileMenu(){
        Display.clear();
        System.out.println("=========== Profile Edit ===========");
        System.out.println("1. Display infos");
        System.out.println("2. Edit Email");
        System.out.println("3. Edit Address");
        System.out.println("4. Edit Password");
        System.out.println("5. Back to Main Menu");
        System.out.println("9. Menu");
    }

    public static void bankMenu(){
        Display.clear();
        System.out.println("=========== Bank Menu ===========");
        System.out.println("1. Create Account");
        System.out.println("5. Back to Main Menu");
        System.out.println("9. Menu");
    }

    public static void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
