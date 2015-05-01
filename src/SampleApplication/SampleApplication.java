package SampleApplication;

import FormFramework.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class SampleApplication extends JFrame {

    private Container pane;
    private Map<String,String> textFieldValues = new LinkedHashMap<String,String>();

    private JButton registerButton;

    private JLabel welcomeLabel;

    public SampleApplication(){
        setTitle("Login");

        pane = getContentPane();

        pane.setLayout(new GridLayout(2, 4));

        registerButton = new JButton("Register");
        welcomeLabel = new JLabel("Welcome");

        registerButton.addActionListener(new registerButtonEventHandler());


        pane.add(welcomeLabel);
        pane.add(registerButton);

        pack();
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class registerButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Form registerForm = new Form("../SampleApplication/config.properties");
            textFieldValues = registerForm.getTextFieldValues();
            registerForm.dispose();
            updateForm();
        }
    }

    private void updateForm(){
        registerButton.setVisible(false);

        for (Map.Entry<String,String> entry : textFieldValues.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals("name")){
                add(new JLabel(value));
            }
        }
    }

    public static void main(String[] args) {
        SampleApplication main = new SampleApplication();
    }
}
