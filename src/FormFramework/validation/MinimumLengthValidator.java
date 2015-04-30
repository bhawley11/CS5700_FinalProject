package FormFramework.validation;

import FormFramework.elements.FormElement;

public class MinimumLengthValidator implements Validator {

    private int length;

    public MinimumLengthValidator(int length) {
        this.length = length;
    }

    @Override
    public boolean validate(String text, FormElement caller) {
        if(text == null) return false;
        return text.length() >= length;
    }
}
