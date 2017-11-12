package InputOutput;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UserInputProcessor {

    public static void main(String[] args) throws IOException {

        FileProcessor fileProcessor = new FileProcessor();
        UserInputProcessor userInputProcessor = new UserInputProcessor();
        userInputProcessor.useUserInput(fileProcessor);
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

    public String useUserInput(FileProcessor fileProcessor) throws IOException {
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
            useUserInput(fileProcessor);
        }
        System.out.println(city);
        return city;
    }
}