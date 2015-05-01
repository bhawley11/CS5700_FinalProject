package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class IntegerValidator implements Validator {
    @Override
    public boolean validate(String text, FormElement caller) {
        if (text != null && !text.equals("")) {
            boolean allInteger = true;
            char[] charArray = text.toCharArray();

            for (char c : charArray) {
                if (!Character.isDigit(c)) {
                    allInteger = false;
                }
            }

            if(!allInteger) {
                JOptionPane.showMessageDialog(new JFrame(),
                        caller.getLabelName() + " must be only numeric.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return allInteger;
        }

        JOptionPane.showMessageDialog(new JFrame(),
                caller.getLabelName() + " must be only numeric.",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);

        return false;
    }
}