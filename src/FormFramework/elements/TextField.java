package FormFramework.elements;

import FormFramework.validation.Validator;
import javax.swing.*;
import java.util.List;

public class TextField extends JTextField implements FormElement{

    private List<Validator> validators = null;

    public TextField(){
        super();
    }

    @Override
    public boolean checkIsSet() {
        return (!getText().equals(""));
    }

    @Override
    public void addValidator(Validator validator){
        validators.add(validator);
    }

    @Override
    public boolean validateElement()  {
        boolean allPassed = true;

        if(validators.isEmpty()) return true;

        for(Validator v : validators) {
            if(!v.validate(getText(), this)) {
                allPassed = false;
            }
        }

        return allPassed;
    }
}
