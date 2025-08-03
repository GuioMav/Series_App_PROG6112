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

    public static int validateSeriesAge(Scanner scanner) {
        int seriesAge;
        while (true) {
            try {
                System.out.print("Enter the series age restriction (between 2 and 18): ");
                seriesAge = Integer.parseInt(scanner.nextLine());

                if (seriesAge < 2 || seriesAge > 18) {
                    System.out.println("You have entered an incorrect series age!!! Please re-enter.");
                } else {
                    return seriesAge;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please re-enter the series age.");
            }
        }
    }
}
