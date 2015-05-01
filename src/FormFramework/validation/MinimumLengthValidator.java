package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class MinimumLengthValidator implements Validator {

    private int length;

    public MinimumLengthValidator(int length) {
        this.length = length;
    }

    @Override
    public boolean validate(String text, FormElement caller) {
        if(text == null) return false;
        if(text.length() >= length) {
            return true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(),
                    caller.getLabelName() + " must be longer than " + length + " characters.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
