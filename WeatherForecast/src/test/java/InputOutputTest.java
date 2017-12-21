import InputOutput.FileProcessor;
import InputOutput.UserInputProcessor;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

/**
 * Created by Sandra on 12.11.2017.
 */
public class InputOutputTest {
    FileProcessor fileProcessor = spy(FileProcessor.class);
    UserInputProcessor userInputProcessor = spy(UserInputProcessor.class);

    @Test
    public void doesPathConstructorReturnACorrectFilePath() {
        String fileName = "input.txt";
        final String file = fileProcessor.filePathConstructor(fileName);
        assertEquals("C:\\Users\\Sandra\\IdeaProjects\\Automaattestimine\\Weather\\WeatherForecast\\input_failid\\" + fileName, file);
    }

    @Test
    public void doesGetUserInputReturnList() throws IOException, JSONException {
        assertThat(userInputProcessor.getUserInput(fileProcessor), instanceOf(List.class));
    }


}


