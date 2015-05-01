package FormFramework.tests;

import static org.junit.Assert.*;

import FormFramework.elements.CheckBox;
import FormFramework.elements.ComboBox;
import FormFramework.elements.TextField;
import FormFramework.validation.ValidatorFactory;
import org.junit.Test;

public class RequiredValidatorTest {

    @Test
    public void testEmptyCheckBox() {
        CheckBox cb = new CheckBox("test");
        cb.addValidator(ValidatorFactory.createValidator("required"));
        cb.setSelected(false);
        assertFalse(cb.validateElement());
    }

    @Test
    public void testCheckedCheckBox() {
        CheckBox cb = new CheckBox("test");
        cb.addValidator(ValidatorFactory.createValidator("required"));
        cb.setSelected(true);
        assertTrue(cb.validateElement());
    }

    @Test
    public void testEmptyTextField() {
        TextField tf = new TextField("test");
        tf.addValidator(ValidatorFactory.createValidator("required"));
        tf.setText("");
        assertFalse(tf.validateElement());
    }

    @Test
    public void testNonEmptyTextField() {
        TextField tf = new TextField("test");
        tf.addValidator(ValidatorFactory.createValidator("required"));
        tf.setText("word");
        assertTrue(tf.validateElement());
    }

    @Test
    public void testEmptyComboBox() {
        ComboBox cb = new ComboBox("test");
        cb.insertItemAt("", 0);
        cb.insertItemAt("notEmpty", 1);
        cb.setSelectedIndex(0);
        cb.addValidator(ValidatorFactory.createValidator("required"));
        assertFalse(cb.validateElement());
    }

    @Test
    public void testNonEmptyComboBox() {
        ComboBox cb = new ComboBox("test");
        cb.insertItemAt("", 0);
        cb.insertItemAt("notEmpty", 1);
        cb.setSelectedIndex(1);
        cb.addValidator(ValidatorFactory.createValidator("required"));
        assertTrue(cb.validateElement());
    }
}
