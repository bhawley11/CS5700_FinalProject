package FormFramework;

import FormFramework.action.*;
import FormFramework.elements.*;
import FormFramework.validation.Validator;
import FormFramework.validation.ValidatorFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Form extends JDialog implements ActionListener {

    private List<FormElement> formElements = new ArrayList<>();
    private ActionHandler actionToPerform;

    public Form(String configFileName) {
        Properties config = loadFormConfig(configFileName);
        setTitle(config.get("form.title").toString());
        setUpElementsFromConfig(config);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(new JLabel());
        add(submitButton);

        pack();
        setSize(400, getSize().height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Properties loadFormConfig(String configFileName) {
        Properties config = new Properties();
        InputStream in = getClass().getResourceAsStream(configFileName);
        try {
            config.load(in);
        } catch (IOException e) {
            System.err.println("Error loading form configuration");
            e.printStackTrace();
            System.exit(ERROR);
        }
        return config;
    }

    private void setUpElementsFromConfig(Properties config) {
        String fieldAmountString = config.get("form.numberOfFields").toString();
        int fieldAmount = Integer.parseInt(fieldAmountString);
        int validatorAmount = 0;
        FormElement ele;

        for(int i = 1; i <= fieldAmount; ++i) {
            switch(config.get("form.field" + i + ".type").toString()) {
                case "checkbox":
                    ele = new CheckBox();
                    validatorAmount = Integer.parseInt(config.get("form.field" + i + ".numberOfValidators").toString());

                    for(int j = 1; j <= validatorAmount; ++j) {
                        ele.addValidator(ValidatorFactory.createValidator(config.get("form.field" + i + ".validator" + j).toString()));
                    }

                    add(new JLabel(config.get("form.field" + i + ".name").toString()));
                    add((CheckBox) ele);

                    break;

                case "combobox":
                    ele = new ComboBox();
                    validatorAmount = Integer.parseInt(config.get("form.field" + i + ".numberOfValidators").toString());

                    for(int j = 1; j <= validatorAmount; ++j) {
                        ele.addValidator(ValidatorFactory.createValidator(config.get("form.field" + i + ".validator" + j).toString()));
                    }

                    add(new JLabel(config.get("form.field" + i + ".name").toString()));
                    add((ComboBox) ele);

                    break;

                case "textfield":
                    ele = new TextField();
                    validatorAmount = Integer.parseInt(config.get("form.field" + i + ".numberOfValidators").toString());

                    for(int j = 1; j <= validatorAmount; ++j) {
                        ele.addValidator(ValidatorFactory.createValidator(config.get("form.field" + i + ".validator" + j).toString()));
                    }

                    add(new JLabel(config.get("form.field" + i + ".name").toString()));
                    add((TextField) ele);

                    break;

                default:
                    return;
            }
            formElements.add(ele);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    private boolean validateForm() {
        boolean allPassed = true;

        for(FormElement fe : formElements) {
            if(!fe.validateElement()) {
                allPassed = false;
            }
        }

        return allPassed;
    }
}
