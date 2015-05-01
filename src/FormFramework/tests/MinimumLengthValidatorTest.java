package FormFramework.tests;

import FormFramework.elements.TextField;
import FormFramework.validation.MinimumLengthValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MinimumLengthValidatorTest {

    private MinimumLengthValidator val = new MinimumLengthValidator(3);

    @Test
    public void testMinLength() {
        assertTrue(val.validate("wor", new TextField("test")));
    }

    @Test
    public void testOverLength() {
        assertTrue(val.validate("wordwordword", new TextField("test")));
    }

    @Test
    public void testJustUnder() {
        assertFalse(val.validate("wo", new TextField("test")));
    }

    @Test
    public void testWithNumeric() {
        assertTrue(val.validate("w0rd", new TextField("test")));
    }

    @Test
    public void testWhitespace() {
        assertFalse(val.validate("", new TextField("test")));
    }

    @Test
    public void testNull() {
        assertFalse(val.validate(null, new TextField("test")));
    }
}
