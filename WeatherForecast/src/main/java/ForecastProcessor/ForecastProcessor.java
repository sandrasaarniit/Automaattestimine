package ForecastProcessor;

import Responses.ResponseWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ForecastProcessor {


    public ArrayList<String> getCurrentWeatherInArrayList(String city) throws IOException, JSONException {
            ArrayList<String> content = new ArrayList<>();
            ResponseWriter responseWriter = new ResponseWriter();
            JSONObject forecastAsJSONObject = responseWriter.getForecastDataJSONObject(city);
            JSONArray forecastAsJSONArray = responseWriter.getForecastDataJSONArray(city);
            Double lat = responseWriter.getLatitude(forecastAsJSONObject);
            Double lon = responseWriter.getLongitude(forecastAsJSONObject);
            Double maxtemp = responseWriter.getMaxTemp(forecastAsJSONArray, 0);
            Double mintemp = responseWriter.getMinTemp(forecastAsJSONArray, 0);
            String date = responseWriter.getDateInText(forecastAsJSONArray, 0);
            content.add("Latitude: " + lat.toString());
            content.add("Logitude: " + lon.toString());
            content.add("Max temp: " + maxtemp.toString());
            content.add("Min temp: " + mintemp.toString());
            content.add("Date: " + date);
        return content;
    }


    public ArrayList<Double> getLatLonOfCityFromUrlResponseInArrayList(JSONObject dataAsJSONObject, ResponseWriter responseWriter) throws JSONException {
        Double lat = responseWriter.getLatitude(dataAsJSONObject);
        Double lon = responseWriter.getLongitude(dataAsJSONObject);
        ArrayList<Double> latAndLon = new ArrayList<>();
        latAndLon.add(lat);
        latAndLon.add(lon);
        return latAndLon;
    }

}
