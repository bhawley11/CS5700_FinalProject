package FormFramework.validation;

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
                return new IntegerRangeValidator(0, 0);
            case "length.minimum":
                return new MinimumLengthValidator(1);
            case "required":
                return new RequiredValidator();
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
