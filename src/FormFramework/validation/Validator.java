package FormFramework.validation;

import FormFramework.elements.FormElement;

public interface Validator {
    boolean validate(String text, FormElement caller);
}
