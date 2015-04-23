package FormFramework;

import FormFramework.validation.Validator;

import javax.swing.*;

/**
 * Created by Brenton on 4/22/2015.
 */
public class CheckBox extends JCheckBox {

    private Validator validator = null;

    public CheckBox() {
        super();
    }

    public void setValidator(Validator val) {
        this.validator = val;
    }

    public boolean validateCheckBox() {
        return validator == null || validator.validate("");
    }
}
