package FormFramework.validation;

import FormFramework.elements.FormElement;

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
            return number >= min && number <= max;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}