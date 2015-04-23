package FormFramework.validation.textFieldValidation;

import FormFramework.validation.Validator;

/**
 * Created by Brenton on 4/22/2015.
 */
public class LowerCaseValidator implements Validator {
    @Override
    public boolean validate(String text) {
        return true;
    }
}
