package FormFramework.validation;

public class ValidatorFactory {

    // Validators with no arguments
    public static Validator createValidator(String type) {
        switch(type) {
            case "alpha":
                return new AlphabeticValidator();
            case "case.lower":
                return new LowerCaseValidator();
            case "integer":
                return new IntegerValidator();
            case "integer.range":
                return new IntegerRangeValidator(0, 10);
            case "length.minimum":
                return new MinimumLengthValidator(6);
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

    //Validators with one argument
    public static Validator createValidator(String type, int a) {
        switch(type) {
            case "length.minimum":
                return new MinimumLengthValidator(a);
            default:
                try {

                    ClassLoader classLoader = ValidatorFactory.class.getClassLoader();
                    Class<?> textFieldValidatorClass = classLoader.loadClass(type);
                    return (Validator) textFieldValidatorClass.getDeclaredConstructor(String.class).newInstance(a);

                } catch (Exception e) {

                    System.err.println("Error creating validator");
                    e.printStackTrace();
                    System.exit(0);

                }
            return null;
        }
    }

    //Validators with two arguments
    public static Validator createValidator(String type, int a, int b) {
        switch(type) {
            case "integer.range":
                return new IntegerRangeValidator(a, b);
            default:
                try {

                    ClassLoader classLoader = ValidatorFactory.class.getClassLoader();
                    Class<?> textFieldValidatorClass = classLoader.loadClass(type);
                    return (Validator) textFieldValidatorClass.getDeclaredConstructor(String.class).newInstance(a, b);

                } catch (Exception e) {

                    System.err.println("Error creating validator");
                    e.printStackTrace();
                    System.exit(0);

                }
                return null;
        }
    }
}
