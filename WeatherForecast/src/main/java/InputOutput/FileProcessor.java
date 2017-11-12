package InputOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileProcessor {
    public String filePathConstructor (String filenameWithExtension) {
        return new File("C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\input_failid\\"+filenameWithExtension).toString();
    }

    public String fileReader (String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).toString();
    }

}