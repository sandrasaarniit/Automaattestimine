package InputOutput;

import Responses.ResponseWriter;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInputProcessor {

    public static void main(String[] args) throws IOException, JSONException {

        FileProcessor fileProcessor = new FileProcessor();
        UserInputProcessor userInputProcessor = new UserInputProcessor();
        userInputProcessor.getUserInput(fileProcessor);
    }

    private String readUserEnteredCity(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the city name: ");
        return scanner1.next();
    }

    private String readUserEnteredFileName(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the file name with extension: ");
        return scanner1.next();
    }

    public List<String> getUserInput(FileProcessor fileProcessor) throws IOException, JSONException {
        System.out.println("How would you like to choose the city?");
        System.out.println("Enter 1 if you want to enter the city name from console or 2 if you want to read it from a file");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.next();
        List<String> cities = new ArrayList<>();
        if (Objects.equals(method,"1")){
            cities.add(readUserEnteredCity());
        }else if (Objects.equals(method, "2")){
            String fileName = readUserEnteredFileName();
            List<String> fileRead = fileProcessor.fileReader(fileProcessor.filePathConstructor(fileName));
            cities.addAll(fileRead);
        }else{
            getUserInput(fileProcessor);
        }
        System.out.println(cities);
        return cities;
    }
    public void useUserInput(FileProcessor fileProcessor, ResponseWriter responseWriter) throws IOException, JSONException {
        UserInputProcessor userInputProcessor = new UserInputProcessor();
        List<String> cities = userInputProcessor.getUserInput(fileProcessor);
        fileProcessor.writeCityForecastToFile(cities, responseWriter);
        System.out.println(cities+" data added to file");
    }
}