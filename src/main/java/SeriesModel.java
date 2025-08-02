public class SeriesModel {
    private String seriesId;
    private String seriesName;
    // Note: regarding the "seriesAgeRestriction", in the instructions it is required to use a "String" but on point 1.3 of the same, we must implement a function to determine if and only allow ages between 2 and 18, which would overcomplicated the logic while we can simplify it using int instead of string for a simpler function
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    // Constructor
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getters and Setters
    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public int getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesId + ", Name: " + seriesName + ", Age: " + seriesAge + ", Episodes: " + seriesNumberOfEpisodes;
    }
}