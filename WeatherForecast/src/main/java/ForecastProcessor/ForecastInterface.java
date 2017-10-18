package ForecastProcessor;

import Responses.ResponseWriter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public interface ForecastInterface {

    ArrayList<String> getCurrentWeatherInArrayList(String city) throws IOException, JSONException;
    ArrayList<Double> getLatLonOfCityFromUrlResponseInArrayList(JSONObject dataFromURLBodyInStringForm, ResponseWriter responseController) throws JSONException;

}
