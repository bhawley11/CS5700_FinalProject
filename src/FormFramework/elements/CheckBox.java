package FormFramework.elements;

import FormFramework.validation.Validator;
import javax.swing.*;
import java.util.List;

public class CheckBox extends JCheckBox implements FormElement{

    private List<Validator> validators = null;

    public CheckBox() {
        super();
    }

    @Override
    public boolean checkIsSet() {
        return isSelected();
    }

    @Override
    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    @Override
    public boolean validateElement()  {
        boolean allPassed = true;

        if(validators.isEmpty()) return true;

        for(Validator v : validators) {
            if(!v.validate("")) {
                allPassed = false;
            }
        }

        return allPassed;
    }
}