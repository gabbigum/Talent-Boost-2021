package test.vmware.tb.io.tasks;

import main.vmware.tb.io.tasks.Rotate13;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Rotate13Test {

    private Rotate13 rotate13;

    @Before
    public void setup() {
        rotate13 = new Rotate13();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        rotate13.rotate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyString() {
        rotate13.rotate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithBlankString() {
        rotate13.rotate("   ");
    }

    @Test
    public void testRotateWithLowerCaseALetter() {
        String expected = "n";
        assertEquals(expected, rotate13.rotate("a"));
    }

    @Test
    public void testRotateWithLowerCaseNLetter() {
        String expected = "a";
        assertEquals(expected, rotate13.rotate("n"));
    }

    @Test
    public void testRotateWithUpperCaseALetter() {
        String expected = "N";
        assertEquals(expected, rotate13.rotate("A"));
    }

    @Test
    public void testRotateWithUpperCaseNLetter() {
        assertEquals("A", rotate13.rotate("N"));
    }

    @Test
    public void testRotateWithUpperCaseALettersAndWhiteSpaces() {
        String expected = "N Z M";
        assertEquals(expected, rotate13.rotate("A M Z"));
    }

    @Test
    public void testRotateWithUpperCaseString() {
        String expected = "Grfg";
        assertEquals(expected, rotate13.rotate("Test"));
    }

    @Test(timeout = 5000L)
    public void testRotateWithLargeString() {
        char[] chars = new char[10_000_000];
        Arrays.fill(chars, 'a');
        String largeString = String.valueOf(chars);

        String rotate = rotate13.rotate(largeString);

        assertNotNull(rotate);
    }
}
