package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class IntegerRangeValidator implements Validator {

    private int min;
    private int max;

    public IntegerRangeValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validate(String text, FormElement caller) {
        try {
            int number = Integer.parseInt(text);
            if(number >= min && number <= max) {
                return true;
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        caller.getLabelName() + " must be >= " + min + " and <= " + max + ".",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    caller.getLabelName() + " must be a number >= " + min + " and <= " + max + ".",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}