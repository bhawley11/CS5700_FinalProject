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
    private Map<String,String> comboBoxValues = new LinkedHashMap<String,String>();
    private Map<String,String> checkBoxValues = new LinkedHashMap<String,String>();

    private JButton registerButton;

    private JLabel welcomeLabel;
    private JLabel ageLabel;
    private JLabel termsLabel;
    private JLabel successfulRegistration;

    public SampleApplication(){
        setTitle("Login");

        pane = getContentPane();

        pane.setLayout(new GridLayout(5, 1));


        registerButton = new JButton("Register");
        welcomeLabel = new JLabel("Welcome");
        ageLabel = new JLabel();
        termsLabel = new JLabel();
        successfulRegistration = new JLabel();

        registerButton.addActionListener(new registerButtonEventHandler());

        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        termsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successfulRegistration.setHorizontalAlignment(SwingConstants.CENTER);

        pane.add(welcomeLabel);
        pane.add(ageLabel);
        pane.add(termsLabel);
        pane.add(successfulRegistration);
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
            comboBoxValues = registerForm.getComboBoxValues();
            checkBoxValues = registerForm.getCheckBoxValues();
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
                welcomeLabel.setText("Welcome, " + value);
            }
            if(key.equals("age")){
                ageLabel.setText("Age: " + value);
            }
        }
        for(Map.Entry<String,String> entry : checkBoxValues.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals("Accept Terms and Conditions") && value.equals("checked")){
                termsLabel.setText("Accepted Terms and Conditions: YES");
            }
        }
        successfulRegistration.setText("You have registered Successfully!");
    }

    public static void main(String[] args) {
        SampleApplication main = new SampleApplication();
    }
}
