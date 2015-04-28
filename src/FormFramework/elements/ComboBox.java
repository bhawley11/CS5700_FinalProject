package FormFramework.elements;

import FormFramework.validation.Validator;
import javax.swing.*;
import java.util.List;

public class ComboBox extends JComboBox implements FormElement{

    private List<Validator> validators = null;

    public ComboBox() {
        super();
    }

    @Override
    public boolean checkIsSet() {
        return (!getSelectedItem().toString().equals("") && getSelectedItem() != null);
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
            if(!v.validate(getSelectedItem().toString())) {
                allPassed = false;
            }
        }

        return allPassed;
    }
}
