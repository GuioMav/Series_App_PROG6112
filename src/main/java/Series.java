import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    ArrayList<SeriesModel> seriesList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

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
                int seriesAge = 0;
                while (true) {
                    try {
                        System.out.print("Enter the series age restriction (between 2 and 18): ");
                        seriesAge = Integer.parseInt(scanner.nextLine());

                        if (seriesAge < 2 || seriesAge > 18) {
                            System.out.println("You have entered an incorrect series age!!! Please re-enter.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number! Please re-enter the series age.");
                    }
                }

                // Episodes
                System.out.print("Enter the number of episodes for " + seriesName + ": ");
                int seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());

                // Success
                System.out.println("Series processed successfully!");

                // Add to list
                SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
                seriesList.add(newSeries);

                break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
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
    }

    public void updateSeries() {
        System.out.println("[Placeholder] Update Series");
        // To be implemented
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