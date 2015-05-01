package FormFramework.tests;

import FormFramework.elements.TextField;
import FormFramework.validation.LowerCaseValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LowerCaseValidatorTest {

    private LowerCaseValidator val = new LowerCaseValidator();

    @Test
    public void testAlphaMixedCase() {
        assertFalse(val.validate("wOrD", new TextField("test")));
    }

    @Test
    public void testAllLower() {
        assertTrue(val.validate("word", new TextField("test")));
    }

    @Test
    public void testAllUpper() {
        assertFalse(val.validate("WORD", new TextField("test")));
    }

    @Test
    public void testStringWithNum() {
        assertFalse(val.validate("w0rd", new TextField("test")));
    }

    @Test
    public void testWhiteSpace() {
        assertFalse(val.validate("", new TextField("test")));
    }

    @Test
    public void testNullString() {
        assertFalse(val.validate(null, new TextField("test")));
    }
}
