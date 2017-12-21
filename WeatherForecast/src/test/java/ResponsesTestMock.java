import Responses.ResponseWriter;
import UrlBuilder.UrlBuilder;
import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

public class ResponsesTestMock {

    @Test
    public void doesMakeStringToJSONReturnCorrectData() throws IOException, JSONException {
        ResponseWriter responseWriter = new ResponseWriter();
        UrlBuilder urlBuilder = Mockito.mock(UrlBuilder.class);
        String testResponse = "{\"dt\":1513849800,\"coord\":{\"lon\":26.72,\"lat\":58.37},\"visibility\":2100,\"weather\":[{\"icon\":\"13d\",\"description\":\"light rain and snow\",\"main\":\"Snow\",\"id\":615},{\"icon\":\"50d\",\"description\":\"mist\",\"main\":\"Mist\",\"id\":701}],\"name\":\"Tartu\",\"cod\":200,\"main\":{\"temp\":-1,\"temp_min\":-1,\"humidity\":100,\"pressure\":1014,\"temp_max\":-1},\"clouds\":{\"all\":90},\"id\":588335,\"sys\":{\"country\":\"EE\",\"sunrise\":1513839647,\"sunset\":1513862531,\"id\":5015,\"type\":1,\"message\":0.0032},\"base\":\"stations\",\"wind\":{\"deg\":200,\"speed\":6.7}}";
        URL url = new  URL("http://api.openweathermap.org//data/2.5/weather?q=Tartu&APPID=ca9ad2101b85b5a42472f856681dd662&units=metric");
        Mockito.when(urlBuilder.getResponseBodyFromURL(url)).thenReturn(testResponse);
        System.out.println(responseWriter.makeStringToJSON(testResponse));
        assertEquals(responseWriter.makeStringToJSON(testResponse).toString(), testResponse.toString());
    }

    @Test
    public void ifDataReturnCorrectAmountOfTimes() throws IOException, JSONException{

        ResponseWriter responseWriter = new ResponseWriter();
        String testResponse = "{\"dt\":1513849800,\"coord\":{\"lon\":26.72,\"lat\":58.37},\"visibility\":2100,\"weather\":[{\"icon\":\"13d\",\"description\":\"light rain and snow\",\"main\":\"Snow\",\"id\":615},{\"icon\":\"50d\",\"description\":\"mist\",\"main\":\"Mist\",\"id\":701}],\"name\":\"Tartu\",\"cod\":200,\"main\":{\"temp\":-1,\"temp_min\":-1,\"humidity\":100,\"pressure\":1014,\"temp_max\":-1},\"clouds\":{\"all\":90},\"id\":588335,\"sys\":{\"country\":\"EE\",\"sunrise\":1513839647,\"sunset\":1513862531,\"id\":5015,\"type\":1,\"message\":0.0032},\"base\":\"stations\",\"wind\":{\"deg\":200,\"speed\":6.7}}";
        URL currentWeatherUrl = new URL("http://api.openweathermap.org//data/2.5/weather?q=Tartu&APPID=ca9ad2101b85b5a42472f856681dd662&units=metric");
        UrlBuilder urlBuilder = Mockito.mock(UrlBuilder.class);
        Mockito.when(urlBuilder.getResponseBodyFromURL(currentWeatherUrl)).thenReturn(testResponse);
        responseWriter.makeStringToJSON(testResponse);
        Mockito.verify(urlBuilder, times(1)).getResponseBodyFromURL(currentWeatherUrl);

    }
}
