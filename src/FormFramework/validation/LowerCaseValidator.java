package FormFramework.validation;

import FormFramework.elements.FormElement;

import javax.swing.*;

public class LowerCaseValidator implements Validator {
    @Override
    public boolean validate(String text, FormElement caller) {
        if (text != null && !text.equals("")) {
            boolean allLower = true;
            char[] charArray = text.toCharArray();

            for (char c : charArray) {
                if (c < 'a' || c > 'z') {
                    allLower = false;
                }
            }

            if(!allLower) {
                JOptionPane.showMessageDialog(new JFrame(),
                        caller.getLabelName() + " must be all lower case.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return allLower;
        }

        JOptionPane.showMessageDialog(new JFrame(),
                caller.getLabelName() + " must be all lower case.",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);

        return false;
    }
}
