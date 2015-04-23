package FormFramework;

import FormFramework.validation.Validator;

import javax.swing.*;

/**
 * Created by Shaun on 4/22/2015.
 */
public class TextField extends JTextField{

    private Validator validator = null;

    public TextField(){
        super();
    }

    public void setValidator(Validator val) {
        this.validator = val;
    }

    public boolean validateTextField() {
        return validator == null || validator.validate(getText());
    }
}
