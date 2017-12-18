import ForecastProcessor.ForecastProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ForecastProcessorTestMock {

    private ForecastProcessor forecastProcessor;
    private ArrayList<String> cityName;
    private ArrayList<String> dataOfTartu = new ArrayList<>();

    @Before
    public void init() {
        forecastProcessor = new ForecastProcessor();
        cityName = new ArrayList<>(
                Arrays.asList("Tartu"));

    }
    @Test
    public void doesGetCurrentWeatherInArrayListGetCorrectData() throws Exception{
        String testStringOfTartuData = "[Tartu [Latitude: 58.3727, Logitude: 26.7238, Max temp: -3.04, Min temp: -6.03, Date: 2017-12-20]]";
        dataOfTartu.add(testStringOfTartuData);
        forecastProcessor = Mockito.mock(ForecastProcessor.class);

        Mockito.when(forecastProcessor.getCurrentWeatherInArrayList(cityName)).thenReturn(dataOfTartu);
        assertEquals(forecastProcessor.getCurrentWeatherInArrayList(cityName).size(), dataOfTartu.size());
        assertEquals(forecastProcessor.getCurrentWeatherInArrayList(cityName), dataOfTartu);

    }

}
