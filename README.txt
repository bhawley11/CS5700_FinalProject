We have written a complete form framework, allowing for user configuration and dynamic creation of forms.
Included in the project is an image of our class diagram. This goes into detail regarding the design and
architecture.

The user can make their own config.properties which will dynamically change the look and act
of the form. It will load in the number of TextFields, checkboxes, and comboboxes the config file specifies.
Then it will create the different types of validation that the above input methods will use. Some inputs
might take multiple validations which will be specified in the config file as an array.

The form will also dynamically load the action that will be taken when the form is validated. This will allow
the user to specify what action will take place upon validation.

The user will be able to create new validations and new actions and simply add them to the config file. The validator
factory will handle all cases and if not a default validator it will try loading a new class validator from the config file.
The same will happen for the action performed. This will allow the user to create as many custom validators as they choose,
and as many custom actions as they choose.

Upon validation the form will return the results of the action performed to a external calling class. This class will update
and display the information. 