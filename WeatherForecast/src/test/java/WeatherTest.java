import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by Sandra on 25.09.2017.
 */
public class WeatherTest {
    Weather weather = new Weather();


    @Test
    public void testTemperatureNow() {
        assertEquals(0, weather.getTemperatureNow());
    }

    @Test
    public void testTemperatureOfThreeDays() throws IOException{
        final JSONArray response = weather.getWeatherForecast();
        int forecastReceived = response.lenght();
        assertEquals(3, forecastReceived);
    }

    @Test
    public void testTemperatures() {
        boolean testHighTemp = 0<weather.getHighestTemperatureOfThreeDays()<100;
        assertEquals(testHighTemp, true);
        boolean testLowTemp = 0<weather.getLowestTemperatureOfThreeDays()<100;
        assertEquals(testLowTemp, true);
    }

    @Test
    public void testCoordinates() {
        boolean isCorrectFormat = weather.getCoordinates().matches("\\d{3}.\\d{3}");
        assertEquals(isCorrectFormat, true);
    }


}
