package FormFramework.tests;

import static org.junit.Assert.*;

import FormFramework.elements.TextField;
import FormFramework.validation.IntegerRangeValidator;
import org.junit.Test;

public class IntegerRangeValidatorTest {

    private IntegerRangeValidator val = new IntegerRangeValidator(1, 10);

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

    @Test
    public void testBorderVal() {
        assertTrue(val.validate("10", new TextField("test")));
    }

    @Test
    public void testTooHigh() {
        assertFalse(val.validate("11", new TextField("test")));
    }

    @Test
    public void testNeg() {
        assertFalse(val.validate("-1", new TextField("test")));
    }
}
