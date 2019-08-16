import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class InputHandlerTest {
    @Test
    public void testDiceRerollWithCommas() {
        ByteArrayInputStream in = new ByteArrayInputStream("2,3".getBytes());
        System.setIn(in);

        Assert.assertEquals("2,3" , InputHandler.validateAndReturnUserInputForDiceReroll(in));
    }

    @Test
    public void testDiceRerollWithoutCommas() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        String test = InputHandler.validateAndReturnUserInputForDiceReroll(in);

        Assert.assertEquals("2" , test);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDiceRerollWithCommaBehind() {
        ByteArrayInputStream in = new ByteArrayInputStream(",2".getBytes());
        System.setIn(in);

        InputHandler.validateAndReturnUserInputForDiceReroll(in);
    }
}
