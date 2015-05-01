package FormFramework.elements;

import FormFramework.validation.Validator;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBox extends JCheckBox implements FormElement{

    private List<Validator> validators = new ArrayList<Validator>();
    private String label;

    public CheckBox(String label) {
        super();
        this.label = label;
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
            if(!v.validate("", this)) {
                allPassed = false;
            }
        }

        return allPassed;
    }

    @Override
    public String getLabelName(){
        return this.label;
    }
}
