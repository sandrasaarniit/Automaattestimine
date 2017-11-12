import InputOutput.FileProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sandra on 12.11.2017.
 */
public class InputOutputTest {
    private FileProcessor fileProcessor = new FileProcessor();
    @Test
    public void doesPathConstructorReturnACorrectFilePath(){
        String fileName = "input.txt";
        final String file = fileProcessor.filePathConstructor(fileName);
        assertEquals("C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\input_failid\\"+ fileName, file);
    }
}
