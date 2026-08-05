package homework_13;

import java.util.Scanner;
//Написать try/catch/finally, в котором finally вызван не будет
public class UserMain {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String login;
            String password;
            String confirmPassword;
            System.out.print("Login:");
            login = input.nextLine();
            System.out.print("Password:");
            password = input.nextLine();
            System.out.print("Confirm Password:");
            confirmPassword = input.nextLine();

            if (User.registerUser(login, password, confirmPassword)){
                System.out.println("\nWelcome "+login);
            }
            System.exit(0);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            System.out.println("Goodbye!");
        }
    }
}
