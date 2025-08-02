import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Series seriesApp = new Series();
        Scanner scanner = new Scanner(System.in);
        //Display the start menu
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        try {
            String startKey = scanner.next();
            if(startKey.equals("1")) {

                //Display the Main Menu
                System.out.println("Please select one of the following menu items: ");
                System.out.println("(1) Capture a new Series");
                System.out.println("(2) Search for a series");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete a series");
                System.out.println("(5) Print series report");
                System.out.println("(6) Exit Application");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> seriesApp.captureSeries();
                    case 2 -> System.out.println("search for a series");
                    case 3 -> System.out.println("update a series age restriction");
                    case 4 -> System.out.println("Delete a series");
                    case 5 -> System.out.println("Print series report");
                    case 6 -> System.exit(0);
                }

            } else {
                System.out.println("You exited");

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }
}