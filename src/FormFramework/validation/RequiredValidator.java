package FormFramework.validation;

import FormFramework.elements.FormElement;

public class RequiredValidator implements Validator {
    @Override
    public boolean validate(String text, FormElement caller) {
        return caller.checkIsSet();
    }
}
