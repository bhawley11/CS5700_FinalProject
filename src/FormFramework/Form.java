package FormFramework;

import FormFramework.action.*;
import FormFramework.elements.*;
import FormFramework.elements.TextField;
import FormFramework.validation.Validator;
import FormFramework.validation.ValidatorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class Form extends JDialog implements ActionListener {

    private List<FormElement> formElements = new ArrayList<>();
    private Map<String,String> textFieldValues = new LinkedHashMap<String,String>();
    private Map<String,String> checkboxValues = new LinkedHashMap<String,String>();
    private Map<String,String> comboBoxValues = new LinkedHashMap<String,String>();

    private ActionHandler actionToPerform;

    public Form(String configFileName) {
        setModal(true);
        Properties config = loadFormConfig(configFileName);
        setTitle(config.getProperty("form.title"));
        setUpElementsFromConfig(config);
        setUpActionFromConfig(config);

        setLayout(new GridLayout(Integer.parseInt(config.getProperty("form.numberOfFields")) + 1, 2));
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(new JLabel());
        add(submitButton);

        pack();
        setSize(400, getSize().height);
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        String fieldAmountString = config.getProperty("form.numberOfFields");
        int fieldAmount = Integer.parseInt(fieldAmountString);
        int validatorAmount;
        int textIndex = 1;
        int boxIndex = 1;
        int checkIndex = 1;

        FormElement ele;

        for(int i = 1; i <= fieldAmount; ++i) {
            switch(config.getProperty("form.field" + i + ".type")) {
                case "checkbox":
                    ele = new CheckBox(config.getProperty("form.field" + i + ".name"));
                    validatorAmount = Integer.parseInt(config.getProperty("form.field" + i + ".numberOfValidators"));

                    for(int j = 1; j <= validatorAmount; ++j) {
                        String[] valStrings = config.getProperty("form.field" + i + ".validator" + j).split(Pattern.quote("-"));
                        switch(valStrings.length) {
                            case 1:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0]));
                                break;
                            case 2:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1])));
                                break;
                            case 3:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1]), Integer.parseInt(valStrings[2])));
                        }
                        checkboxValues.put(config.getProperty("form.field" + i + ".name"), "" + checkIndex);
                    }

                    add(new JLabel(config.getProperty("form.field" + i + ".name").toUpperCase()));
                    add((CheckBox) ele);
                    checkIndex++;
                    break;

                case "combobox":
                    ele = new ComboBox(config.getProperty("form.field" + i + ".name"));
                    validatorAmount = Integer.parseInt(config.getProperty("form.field" + i + ".numberOfValidators"));

                    for(int j = 1; j <= validatorAmount; ++j) {
                        String[] valStrings = config.getProperty("form.field" + i + ".validator" + j).split(Pattern.quote("-"));
                        switch(valStrings.length) {
                            case 1:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0]));
                                break;
                            case 2:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1])));
                                break;
                            case 3:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1]), Integer.parseInt(valStrings[2])));
                        }
                        comboBoxValues.put(config.getProperty("form.field" + i + ".name"), "" + boxIndex);
                    }

                    add(new JLabel(config.getProperty("form.field" + i + ".name").toUpperCase()));
                    add((ComboBox) ele);
                    boxIndex++;
                    break;

                case "textfield":
                    ele = new TextField(config.getProperty("form.field" + i + ".name"));
                    validatorAmount = Integer.parseInt(config.getProperty("form.field" + i + ".numberOfValidators"));

                    for(int j = 1; j <= validatorAmount; ++j) {
                        String[] valStrings = config.getProperty("form.field" + i + ".validator" + j).split(Pattern.quote("-"));
                        switch(valStrings.length) {
                            case 1:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0]));
                                break;
                            case 2:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1])));
                                break;
                            case 3:
                                ele.addValidator(ValidatorFactory.createValidator(valStrings[0], Integer.parseInt(valStrings[1]), Integer.parseInt(valStrings[2])));
                        }
                        textFieldValues.put(config.getProperty("form.field" + i + ".name"), "" + textIndex);
                    }
                    textIndex++;
                    add(new JLabel(config.getProperty("form.field" + i + ".name").toUpperCase()));
                    add((TextField) ele);

                    break;

                default:
                    return;
            }
            formElements.add(ele);

        }
    }

    public void setUpActionFromConfig(Properties config) {
        actionToPerform = ActionHandlerFactory.createAction(config.getProperty("form.action"));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(validateForm()) {
            actionToPerform.execute(this);
        }
    }

    private boolean validateForm() {
        boolean allPassed = true;

        for(FormElement fe : formElements) {
            if(!fe.validateElement()) {
                if(fe instanceof TextField){
                    ((TextField) fe).setBackground(Color.red);
                }
                if(fe instanceof CheckBox){
                    ((CheckBox) fe).setBackground(Color.red);
                }
                if(fe instanceof ComboBox){
                    ((ComboBox) fe).setBackground(Color.red);
                }
                allPassed = false;
            }
            else{
                if(fe instanceof TextField){
                    ((TextField) fe).setBackground(Color.green);
                }
                if(fe instanceof CheckBox){
                    ((CheckBox) fe).setBackground(Color.green);
                }
                if(fe instanceof ComboBox){
                    ((ComboBox) fe).setBackground(Color.green);
                }
            }
        }

        return allPassed;
    }

    public Map<String,String> getComboBoxValues(){
        int count = 1;
        for(FormElement field : formElements){
            if(field instanceof ComboBox){
                for(Map.Entry<String,String> entry : comboBoxValues.entrySet()){
                    String value = entry.getValue();
                    int temp;
                    try{
                        temp = Integer.parseInt(value);
                    }
                    catch(NumberFormatException e){
                        continue;
                    }
                    if(temp == count){
                        entry.setValue(((ComboBox) field).getSelectedItem().toString());
                    }
                }
                count++;
            }
        }

        return comboBoxValues;
    }

    public Map<String,String> getCheckBoxValues() {
        int count = 1;
        for(FormElement field : formElements){
            if(field instanceof CheckBox){
                for(Map.Entry<String,String> entry : checkboxValues.entrySet()){
                    String value = entry.getValue();
                    int temp;
                    try{
                        temp = Integer.parseInt(value);
                    }
                    catch(NumberFormatException e){
                        continue;
                    }
                    if(temp == count){
                        if(((CheckBox) field).isSelected()){
                            entry.setValue("checked");
                        }
                        else{
                            entry.setValue("unchecked");
                        }
                    }
                }
                count++;
            }
        }

        return checkboxValues;
    }

    public Map<String,String> getTextFieldValues(){
        int count = 1;
        for(FormElement field : formElements){
            if(field instanceof TextField){
                for (Map.Entry<String,String> entry : textFieldValues.entrySet()) {
                    String value = entry.getValue();
                    int temp;
                    try {
                        temp = Integer.parseInt(value);
                    }
                    catch(NumberFormatException e){
                        continue;
                    }
                    if (temp == count){
                        entry.setValue(((TextField) field).getText());
                    }
                }
                count++;
            }
        }
        return textFieldValues;
    }

}
