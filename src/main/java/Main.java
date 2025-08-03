import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Series seriesApp = new Series();
        Scanner scanner = new Scanner(System.in);

        // Start screen
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        try {
            String startKey = scanner.nextLine();
            if (startKey.equals("1")) {

                // Application loop
                while (seriesApp.running) {
                    // Display main menu
                    System.out.println("\nPlease select one of the following menu items:");
                    System.out.println("(1) Capture a new Series");
                    System.out.println("(2) Search for a series");
                    System.out.println("(3) Update series age restriction");
                    System.out.println("(4) Delete a series");
                    System.out.println("(5) Print series report");
                    System.out.println("(6) Exit Application");

                    String choiceInput = scanner.nextLine();

                    switch (choiceInput) {
                        case "1" -> {
                            seriesApp.captureSeries();
                            AppUtils.promptReturn(scanner, seriesApp);
                        }
                        case "2" -> {
                            seriesApp.searchSeries();
                            AppUtils.promptReturn(scanner, seriesApp);
                        }
                        case "3" -> {
                            seriesApp.updateSeries();
                            AppUtils.promptReturn(scanner, seriesApp);
                        }
                        case "4" -> {
                            seriesApp.deleteSeries();
                            AppUtils.promptReturn(scanner, seriesApp);
                        }
                        case "5" -> {
                            seriesApp.seriesReport();
                            AppUtils.promptReturn(scanner, seriesApp);
                        }
                        case "6" -> {
                            seriesApp.exitSeriesApplication();
                            seriesApp.running = false;
                        }
                        default -> System.out.println("Invalid choice. Please select a number from 1 to 6.");
                    }
                }

            } else {
                System.out.println("You exited");
            }

        } catch (Exception e) {
            // This catch block prevents the app from breaking if any of the methods called to perform the mais function ever returns an error.
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}