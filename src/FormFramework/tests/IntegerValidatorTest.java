package FormFramework.tests;

import FormFramework.elements.TextField;
import FormFramework.validation.IntegerValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerValidatorTest {

    private IntegerValidator val = new IntegerValidator();

    @Test
    public void testNumWithAlpha() {
        assertFalse(val.validate("3a", new TextField("test")));
    }

    @Test
    public void testNum() {
        assertTrue(val.validate("3", new TextField("test")));
    }

    @Test
    public void testAlphaOnly() {
        assertFalse(val.validate("abc", new TextField("test")));
    }

    @Test
    public void testWhiteSpace() {
        assertFalse(val.validate("", new TextField("test")));
    }

    @Test
    public void testNull() {
        assertFalse(val.validate(null, new TextField("test")));
    }
}
