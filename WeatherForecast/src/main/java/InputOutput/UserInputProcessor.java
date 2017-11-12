package InputOutput;

import Responses.ResponseWriter;
import org.json.JSONException;

import java.io.IOException;
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

    public String getUserInput(FileProcessor fileProcessor) throws IOException, JSONException {
        System.out.println("How would you like to choose the city?");
        System.out.println("Enter 1 if you want to enter the city name from console or 2 if you want to read it from a file");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.next();
        String city = "";
        if (Objects.equals(method,"1")){
            city = readUserEnteredCity();
        }else if (Objects.equals(method, "2")){
            String fileName = readUserEnteredFileName();
            String fileRead = fileProcessor.fileReader(fileProcessor.filePathConstructor(fileName));
            city = fileRead;
        }else{
            getUserInput(fileProcessor);
        }
        System.out.println(city);
        return city;
    }
    public void useUserInput(FileProcessor fileProcessor, ResponseWriter responseWriter) throws IOException, JSONException {
        UserInputProcessor userInputProcessor = new UserInputProcessor();
        String city = userInputProcessor.getUserInput(fileProcessor);
        fileProcessor.writeCityForecastToFile(city, responseWriter);
        System.out.println(city+" data added to file");
    }
}