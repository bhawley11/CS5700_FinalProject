package FormFramework.elements;

import FormFramework.validation.Validator;


public interface FormElement {
    boolean checkIsSet();
    void addValidator(Validator validator);
    boolean validateElement();
    String getLabelName();
}
