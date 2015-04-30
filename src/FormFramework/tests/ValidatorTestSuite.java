package FormFramework.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AlphabeticValidatorTest.class,
	IntegerRangeValidatorTest.class,
	IntegerValidatorTest.class,
	LowerCaseValidatorTest.class,
	MinimumLengthValidatorTest.class,
	RequiredValidatorTest.class
})

public class ValidatorTestSuite {

}
