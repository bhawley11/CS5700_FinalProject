package SampleApplication;

import FormFramework.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleApplication extends JFrame {

    private Container pane;

    private JButton loginButton,
                    registerButton;

    public SampleApplication(){
        setTitle("Login");

        pane = getContentPane();

        pane.setLayout(new GridLayout(2, 2));

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");



        loginButton.addActionListener(new loginButtonEventHandler());
        registerButton.addActionListener(new registerButtonEventHandler());

        pane.add(loginButton);
        pane.add(registerButton);

        pack();
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class registerButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JDialog registerForm = new Form("../SampleApplication/config.properties");
            registerForm.setVisible(true);
        }
    }

    private class loginButtonEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }





    public static void main(String[] args) {
        SampleApplication main = new SampleApplication();

    }
}
