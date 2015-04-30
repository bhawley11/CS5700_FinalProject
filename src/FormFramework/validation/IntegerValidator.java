package FormFramework.validation;

import FormFramework.elements.FormElement;

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
            return allInteger;
        }
        return false;
    }
}