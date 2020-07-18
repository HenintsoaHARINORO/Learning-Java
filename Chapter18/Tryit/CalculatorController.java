package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CalculatorController implements EventHandler<ActionEvent> {
    private StringProperty displayContent = new SimpleStringProperty("");
    private String previousValue = "";
    private String currentValue = "";
    private double result;
    private String lastOperation;

    Main gui;

    public CalculatorController(Main calculator) {
        gui = calculator;
        gui.displayField.textProperty().bind(displayContent);
    }

    public void handle(ActionEvent evt) {

        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();

        switch (buttonLabel) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case ".":
                processDigit(buttonLabel);
                break;
            default:
                processOperation(buttonLabel);
        }
    }

    private void processOperation(String buttonLabel) {
        switch (buttonLabel) {
            case "+":
                lastOperation = "+";
                addNumbers();
                break;
            case "=":
                if ("+".equals(lastOperation)){
                    addNumbers();
                }
                break;
        }

    }

    private void addNumbers() {
        if ("".equals(previousValue)) {
            previousValue = displayContent.getValue();
            displayContent.setValue("");

        } else {
            currentValue = displayContent.getValue();
            result = Double.parseDouble(previousValue) +
                    Double.parseDouble(currentValue);
            displayContent.setValue("" + result);
        }
    }
    


    private void processDigit(String buttonLabel) {
        displayContent.setValue(displayContent.getValue() + buttonLabel);
    }
}