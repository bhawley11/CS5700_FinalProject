package FormFramework.action;

import FormFramework.Form;

import javax.swing.*;

public class DefaultActionHandler implements ActionHandler {
    public void execute(Form form) {
            form.setVisible(false);
    }
}
