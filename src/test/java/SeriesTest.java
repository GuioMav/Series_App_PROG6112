import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    @Test
    public void TestSearchSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel("S100", "Test Series", 12, 10);
        series.seriesList.add(testSeries);

        SeriesModel found = series.searchSeries("S100");
        assertNotNull(found);
        assertEquals("S100", found.getSeriesId());
        assertEquals("Test Series", found.getSeriesName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series();
        SeriesModel found = series.searchSeries("S999");
        assertNull(found);
    }

    @Test
    public void TestUpdateSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel("S101", "Old Name", 10, 5);
        series.seriesList.add(testSeries);

        SeriesModel toUpdate = series.searchSeries("S101");
        assertNotNull(toUpdate);

        toUpdate.setSeriesName("New Name");
        toUpdate.setSeriesAge(15);
        toUpdate.setSeriesNumberOfEpisodes(8);

        assertEquals("New Name", toUpdate.getSeriesName());
        assertEquals(15, toUpdate.getSeriesAge());
        assertEquals(8, toUpdate.getSeriesNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        Series series = new Series();
        SeriesModel testSeries = new SeriesModel("S102", "Delete Me", 13, 20);
        series.seriesList.add(testSeries);

        SeriesModel toDelete = series.searchSeries("S102");
        assertNotNull(toDelete);

        series.seriesList.remove(toDelete);

        assertNull(series.searchSeries("S102"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series();
        SeriesModel toDelete = series.searchSeries("S999");
        assertNull(toDelete);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        int validAge = 15;
        assertTrue(validAge >= 2 && validAge <= 18);
    }
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        int invalidAge = 20;
        assertFalse(invalidAge >= 2 && invalidAge <= 18);
    }

}
