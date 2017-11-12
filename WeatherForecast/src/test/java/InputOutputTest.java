import InputOutput.FileProcessor;
import InputOutput.UserInputProcessor;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Sandra on 12.11.2017.
 */
public class InputOutputTest {
    private FileProcessor fileProcessor = new FileProcessor();
    private UserInputProcessor userInputProcessor = new UserInputProcessor();
    @Test
    public void doesPathConstructorReturnACorrectFilePath(){
        String fileName = "input.txt";
        final String file = fileProcessor.filePathConstructor(fileName);
        assertEquals("C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\input_failid\\"+ fileName, file);
    }
    @Test
    public void doesGetUserInputReturnString() throws IOException, JSONException {
        assertThat(userInputProcessor.getUserInput(fileProcessor), instanceOf(String.class));
    }
}
