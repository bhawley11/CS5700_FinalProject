package FormFramework.tests;

import static org.junit.Assert.*;

import FormFramework.elements.TextField;
import FormFramework.validation.AlphabeticValidator;
import org.junit.Test;

public class AlphabeticValidatorTest {

    private AlphabeticValidator val = new AlphabeticValidator();

    @Test
    public void testAlphaMixedCase() {
        assertTrue(val.validate("wOrD", new TextField()));
    }

    @Test
    public void testAllLower() {
        assertTrue(val.validate("word", new TextField()));
    }

    @Test
    public void testAllUpper() {
        assertTrue(val.validate("WORD", new TextField()));
    }

    @Test
    public void testStringWithNum() {
        assertFalse(val.validate("w0rd", new TextField()));
    }

    @Test
    public void testWhiteSpace() {
        assertFalse(val.validate("", new TextField()));
    }

    @Test
    public void testNullString() {
        assertFalse(val.validate(null, new TextField()));
    }
}
