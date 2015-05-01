package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class AlphabeticValidator implements Validator {
    @Override
    public boolean validate(String text, FormElement caller) {
        if(text != null && !text.equals("")) {
            boolean allAlpha = true;
            char[] charArray = text.toCharArray();

            for(char c : charArray) {
                if(!Character.isLetter(c)) {
                    allAlpha = false;
                }
            }

            if(!allAlpha) {
                JOptionPane.showMessageDialog(new JFrame(),
                        caller.getLabelName() + " must be alphabetic.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return allAlpha;
        }

        JOptionPane.showMessageDialog(new JFrame(),
                caller.getLabelName() + " must be alphabetic.",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);

        return false;
    }
}