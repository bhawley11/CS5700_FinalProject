package FormFramework.validation;

import FormFramework.elements.FormElement;

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
            return allLower;
        }
        return false;
    }
}
