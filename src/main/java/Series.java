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
                int seriesAge = AppUtils.validateSeriesAge(scanner);
                // Episodes
                int seriesNumberOfEpisodes = 0;
                while(true){
                    try {
                        System.out.print("Enter the number of episodes for " + seriesName + ": ");
                        seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number! Please re-enter the number of episodes");
                    }
                }

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
            int newAge = AppUtils.validateSeriesAge(scanner);
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

    // DELETE SERIES
    public void deleteSeries() {

        //find the specific series to delete
        //send the confirmation message
        //remove it from the array

        System.out.print("Enter the series id to delete: ");
        String idToSearch = scanner.nextLine();

        SeriesModel foundSeries = searchSeries(idToSearch);

        if (foundSeries != null) {
            while(true) {
            //if the series is found display the details in order to change them
            System.out.println("Are you sure you want to delete the series: " + foundSeries.getSeriesId()+ " ( "+ foundSeries.getSeriesName() +" ) from the system? Yes (y) to delete No (n) to cancel.");
            System.out.println("-----------------------------------------");

            String deleteSeries = scanner.nextLine();

            switch (deleteSeries) {
                case "y" -> {
                    seriesList.remove(foundSeries);
                    System.out.println("-----------------------------------------");
                    System.out.println("Series with Id: " + foundSeries.getSeriesId() + " was deleted! ");
                    System.out.println("-----------------------------------------");
                    return;
                }
                case "n" -> {
                    System.out.println("Cancelling deletion...");
                    return;
                }
                default -> {
                    System.out.println("Invalid Input! Please select: Yes (y) to delete No (n) to cancel.");
                }
            }
            }


        } else {
            //if the series is not found, display the message
            System.out.println("-----------------------------------------");
            System.out.println("Series with Series Id: " + idToSearch + " was not found!");
            System.out.println("-----------------------------------------");
        }
    }

    // DISPLAY SERIES REPORT
    public void seriesReport() {
        System.out.println("SERIES REPORT");
        System.out.println("*******************************************");

        if (seriesList.isEmpty()) {
            System.out.println("No series have been captured yet!");
            System.out.println("-----------------------------------------");
            return;
        }

            int seriesNumber = 1;
        for (SeriesModel series : seriesList) {

            System.out.println("Series " + seriesNumber);
            System.out.println("-----------------------------------------");
            System.out.println("SERIES ID: " + series.getSeriesId());
            System.out.println("SERIES NAME: " + series.getSeriesName());
            System.out.println("SERIES AGE RESTRICTION: " + series.getSeriesAge());
            System.out.println("SERIES NUMBER OF EPISODES: " + series.getSeriesNumberOfEpisodes());
            System.out.println("-----------------------------------------");

            seriesNumber ++;
        }
    }

    // EXIT APPLICATION
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