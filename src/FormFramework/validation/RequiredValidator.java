package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class RequiredValidator implements Validator {
    @Override
    public boolean validate(String text, FormElement caller) {
        if(!caller.checkIsSet()) {
            JOptionPane.showMessageDialog(new JFrame(),
                    caller.getLabelName() + " is required.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
