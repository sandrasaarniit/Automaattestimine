package InputOutput;

import ForecastProcessor.ForecastProcessor;
import Responses.ResponseWriter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class FileProcessor {

    private static ForecastProcessor forecastProcessor = new ForecastProcessor();
    private static FileProcessor fileProcessor = new FileProcessor();

    public String filePathConstructor (String filenameWithExtension) {
        return new File("C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\input_failid\\"+filenameWithExtension).toString();
    }

    public String fileReader (String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).toString();
    }

    public void fileWriter(ArrayList<String> currentWeather, ArrayList<String> forecast, String cityName ) throws IOException {
        String directory = "C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\output_failid";
        FileWriter fw = new FileWriter(new File(directory, cityName+".txt"));
        String newLine = System.getProperty("line.separator");
        fw.write("The current weather in " + cityName + " is:" + newLine);
        for (String aContent : currentWeather) {
            fw.write(aContent + newLine);
        }
        fw.write("The maximum and minimum temperatures in " + cityName + " for the next three days are:" + newLine);
        for (String aContent : forecast) {
            fw.write(aContent + newLine);
        }
        fw.close();
    }

    public void writeCityForecastToFile(String city, ResponseWriter responseWriter) throws IOException, JSONException {
            JSONObject dataAsJSONObject = responseWriter.getForecastDataJSONObject(city);
            HashMap<String, Object> threeDays = forecastProcessor.createHashMapOfThreeDayForecast(dataAsJSONObject, responseWriter);
            ArrayList<Double> latAndLon = forecastProcessor.getLatLonOfCityFromUrlResponseInArrayList(dataAsJSONObject, responseWriter);
            ArrayList<String> currentWeather = forecastProcessor.getCurrentWeatherInArrayList(city);
            ArrayList<String> forecast = new ArrayList<>();
            ArrayList<String> current = new ArrayList<>();
            forecast.add(threeDays.toString());
            forecast.add(latAndLon.toString());
            current.add(currentWeather.toString());
            fileProcessor.fileWriter(current, forecast, city);
    }

    public static void main(String[] args) throws IOException, JSONException {
        ResponseWriter responseWriter = new ResponseWriter();
        UserInputProcessor userInputProcessor = new UserInputProcessor();
        userInputProcessor.useUserInput(fileProcessor,responseWriter);

    }



}