package FormFramework.validation.commonValidation;

import FormFramework.validation.Validator;

/**
 * Created by Brenton on 4/22/2015.
 */
public class OptionalValidator implements Validator {
    @Override
    public boolean validate(String text) {
        return true;
    }
}
