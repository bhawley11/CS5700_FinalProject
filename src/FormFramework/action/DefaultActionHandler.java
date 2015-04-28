package FormFramework.action;

import FormFramework.Form;

import javax.swing.*;

public class DefaultActionHandler implements ActionHandler {
    public void execute(Form form) {
        JOptionPane.showMessageDialog(new JFrame(),
                "Passed Validation",
                "Result",
                JOptionPane.PLAIN_MESSAGE);
    }
}
