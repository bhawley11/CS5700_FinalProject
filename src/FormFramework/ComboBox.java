package FormFramework;

import FormFramework.validation.Validator;

import javax.swing.*;

/**
 * Created by Brenton on 4/22/2015.
 */
public class ComboBox extends JComboBox {

    private Validator validator = null;

    public ComboBox() {
        super();
    }

    public void setValidator(Validator val) {
        this.validator = val;
    }

    public boolean validateComboBox() {
        return validator == null || validator.validate(getSelectedItem().toString());
    }
}
