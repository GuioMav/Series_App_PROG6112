import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    ArrayList<SeriesModel> seriesList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;


    // CAPTURE SERIES
    public void captureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("*******************************************");

        try {
            while (running) {
                // ID
                System.out.print("Enter the series id: ");
                String seriesId = scanner.nextLine();
                if (searchSeries(seriesId) != null) {
                    System.out.println("A series with ID '" + seriesId + "' already exists! Please use a different ID.");
                    continue;
                }
                // Name
                System.out.print("Enter the series name: ");
                String seriesName = scanner.nextLine();
                // Age Restriction
                int seriesAge = validateSeriesAge();
                // Episodes
                System.out.print("Enter the number of episodes for " + seriesName + ": ");
                int seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());

                System.out.println("Series processed successfully!");

                // Adding the series to the list
                SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
                seriesList.add(newSeries);

                break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // SEARCH SERIES
    public void searchSeries() {
        System.out.println("SEARCH FOR A SERIES");
        System.out.println("*******************************************");

        System.out.print("Enter the series ID to search: ");
        String idToSearch = scanner.nextLine();

        SeriesModel foundSeries = searchSeries(idToSearch);

        if (foundSeries != null) {
            //if the series is found display the details
            System.out.println("-----------------------------------------");
            System.out.println("SERIES ID: " + foundSeries.getSeriesId());
            System.out.println("SERIES NAME: " + foundSeries.getSeriesName());
            System.out.println("SERIES AGE RESTRICTION: " + foundSeries.getSeriesAge());
            System.out.println("SERIES NUMBER OF EPISODES: " + foundSeries.getSeriesNumberOfEpisodes());
            System.out.println("-----------------------------------------");
        } else {
            //if the series is not found, display the message
            System.out.println("-----------------------------------------");
            System.out.println("Series with Series Id: " + idToSearch + " was not found!");
            System.out.println("-----------------------------------------");
        }
    }

    // UPDATE SERIES
    public void updateSeries() {
        System.out.print("Enter the series id to update: ");
        String idToSearch = scanner.nextLine();

        SeriesModel foundSeries = searchSeries(idToSearch);

        if (foundSeries != null) {
            //if the series is found display the details in order to change them
            System.out.println("    Updating: " + foundSeries.getSeriesName());
            System.out.println("-----------------------------------------");

            // New series name
            System.out.println("Enter the series name: ");
            String newName = scanner.nextLine();
            foundSeries.setSeriesName(newName);
            // New series age
            int newAge = validateSeriesAge();
            foundSeries.setSeriesAge(newAge);
            // New series number of episodes
            System.out.println("Enter the series number of episodes: ");
            int newNumberOfEpisodes = scanner.nextInt();
            foundSeries.setSeriesNumberOfEpisodes(newNumberOfEpisodes);

        } else {
            //if the series is not found, display the message
            System.out.println("-----------------------------------------");
            System.out.println("Series with Series Id: " + idToSearch + " was not found!");
            System.out.println("-----------------------------------------");
        }
    }

    public void deleteSeries() {
        System.out.println("[Placeholder] Delete Series");
        // To be implemented
    }

    public void seriesReport() {
        System.out.println("[Placeholder] Series Report");
        // To be implemented
    }

    public void exitSeriesApplication() {
        System.out.println("Exiting application...");
    }



    // Helper method to validate series age
    private int validateSeriesAge() {
        int seriesAge = 0;
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

    // Helper method
    private SeriesModel searchSeries(String seriesId) {
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(seriesId)) {
                return series;
            }
        }
        return null;
    }
}