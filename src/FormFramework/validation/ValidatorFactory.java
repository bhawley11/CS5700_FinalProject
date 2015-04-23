package FormFramework.validation;

import FormFramework.validation.commonValidation.*;
import FormFramework.validation.textFieldValidation.*;

/**
 * Created by Brenton on 4/22/2015.
 */
public class ValidatorFactory {

    public static Validator createValidator(String type) {
        switch(type) {
            case "alpha":
                return new AlphabeticValidator();
            case "case.lower":
                return new LowerCaseValidator();
            case "integer":
                return new IntegerValidator();
            case "integer.range":
                return new IntegerRangeValidator();
            case "length.minimum":
                return new MinimumLengthValidator();
            case "required.true":
                return new RequiredValidator();
            case "required.false":
                return new OptionalValidator();
            default:
                try {

                    ClassLoader classLoader = ValidatorFactory.class.getClassLoader();
                    Class<?> textFieldValidatorClass = classLoader.loadClass(type);
                    return (Validator) textFieldValidatorClass.newInstance();

                } catch (Exception e) {

                    System.err.println("Error creating validator");
                    e.printStackTrace();
                    System.exit(0);

                }
            return null;
        }
    }
}
