package src.auth;

import java.util.Scanner;

public class Authentication {
    private static final String LOGIN = "Admin";
    private static final String PASSWORD = "321";

    public static int authenticate() {
        Scanner scan = new Scanner(System.in);
        boolean isLoginSuccess = false;
        System.out.print("Логин: ");
        String login = scan.nextLine();
        System.out.print("Пароль: ");
        String password = scan.nextLine();
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                isLoginSuccess = true;
        }
        return isLoginSuccess ? 0 : -1;
    }
}
