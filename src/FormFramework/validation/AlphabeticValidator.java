package FormFramework.validation;

import FormFramework.elements.FormElement;

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
            return allAlpha;
        }

        return false;


    }
}