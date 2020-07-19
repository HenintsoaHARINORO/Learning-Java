package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField displayField;
    public void buttonClickHandler(ActionEvent evt) {
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
        System.out.println("You selected operation "+ buttonLabel);
    }

    private void processDigit(String buttonLabel) {
        displayField.setText(displayField.getText()+ buttonLabel);
    }
}