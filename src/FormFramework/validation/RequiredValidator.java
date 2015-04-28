package FormFramework.validation;

import FormFramework.validation.Validator;

public class RequiredValidator implements Validator {
    @Override
    public boolean validate(String text) {
        return true;
    }
}
