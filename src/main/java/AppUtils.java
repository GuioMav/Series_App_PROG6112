import java.util.Scanner;

public class AppUtils {

    // Prompt Return -> this helper class is used after every action to prompt the user whether they want to continue with another action or if the want to exit the application.
    public static void promptReturn(Scanner scanner, Series seriesApp) {
        System.out.println("Enter (1) to launch menu or any other key to exit)");
        String choice = scanner.nextLine();
        if (!choice.equals("1")) {
            seriesApp.running = false;
        }
    }
}
