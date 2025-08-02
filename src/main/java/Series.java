import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    ArrayList<SeriesModel> seriesList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;


    /* This class implements the interface Series and handles all the CRUD actions logic for the App*/

    public void captureSeries() {

            System.out.println("CAPTURE A NEW SERIES");
            System.out.println("*******************************************");

        try {
            while(running) {

            // ENTER THE SERIES ID
                System.out.print("Enter the series id: ");
                String seriesId = scanner.nextLine();
                //Before adding the Id, we must check if it already exists in our list
                if (searchSeries(seriesId) != null) {
                    System.out.println("A series with ID '" + seriesId + "' already exists! Please use a different ID.");
                    continue;
                }

            // ENTER THE SERIES NAME
                System.out.print("Enter the series name: ");
                String seriesName = scanner.nextLine();

            // ENTER THE SERIES AGE RESTRICTION
                int seriesAge = 0;
                while (running) {
                    try {
                            System.out.print("Enter the series age restriction (between 2 and 18):");
                            seriesAge = Integer.parseInt(scanner.nextLine());

                            if (seriesAge < 2 || seriesAge > 18) {
                                System.out.println("You have entered an incorrect series age!!! ");
                                System.out.println("Please re-enter the series age >>");
                            } else {
                                break;
                            }
                        } catch(NumberFormatException e){
                            System.out.println("You have entered an incorrect series age!!! ");
                            System.out.println("Please re-enter the series age >>");
                        }
                }

            //ENTER THE SERIES NUMBER OF EPISODES
                System.out.print("Enter the number of episodes for " + seriesName + ":");
                int seriesNumberOfEpisodes = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline

                System.out.println("Series processed successfully!!!");

            // Create and store the new series
                SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
                seriesList.add(newSeries);

                break;
            }
        } catch(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("Enter (1 to launch menu or any other key to exit)");
    }

    public void searchSeries() {
        System.out.println("SEARCH FOR A SERIES");
        System.out.println("*******************************************");

        System.out.print("Enter the series ID to search: ");
        String idToSearch = scanner.nextLine();

        SeriesModel foundSeries = searchSeries(idToSearch);

        if (foundSeries != null) {
            System.out.println("Series found!");
            System.out.println(foundSeries);
        } else {
            System.out.println("No series found with ID: " + idToSearch);
        }

        System.out.println("Enter (1 to launch menu or any other key to exit)");
    }

    public void updateSeries() {

    }


    public void deleteSeries() {

    }


    public void seriesReport() {

    }


    public void exitSeriesApplication() {

    }



    //Helper Method
    private SeriesModel searchSeries(String seriesId) {
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(seriesId)) {
                return series;
            }
        }
        return null;
    }

    private void promptToReturnOrExit() {
        System.out.println("Enter (1) to launch menu or any other key to exit)");
        String choice = scanner.nextLine();
        if (!choice.equals("1")) {
            running = false;
        }
    }
}
