package FormFramework.validation;

import FormFramework.validation.Validator;

/**
 * Created by Brenton on 4/22/2015.
 */
public class MinimumLengthValidator implements Validator {

    @Override
    public boolean validate(String text) {
        return true;
    }
}
