import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	Calculator parent; // a reference to the calculator
	double currentNumber, enteredNumber;
	String selectedAction;
	boolean dot;

	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();

		String dispFieldText = parent.getDisplayValue();

		dot = dispFieldText.contains(".");
		if (!dispFieldText.equals(""))
			enteredNumber = Double.parseDouble(dispFieldText);
		if (clickedButton.getText().equals("+")) {
			selectedAction = "+";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");

		} else if (clickedButton.getText().equals("-")) {
			selectedAction = "-";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if (clickedButton.getText().equals("*")) {
			selectedAction = "*";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if (clickedButton.getText().equals("/")) {
			selectedAction = "/";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if (clickedButton.getText().equals("^")) {
			selectedAction = "^";
			currentNumber = enteredNumber;
			parent.setDisplayValue("");
		} else if ((clickedButton == parent.buttonEqual) && (selectedAction != null)) {
			if (selectedAction.equals("+")) {
				currentNumber += enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("-")) {
				currentNumber -= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("*")) {
				currentNumber *= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("/")) {
				currentNumber /= enteredNumber;
				parent.setDisplayValue("" + currentNumber);
			} else if (selectedAction.equals("^")) {
				currentNumber = Math.pow(currentNumber, enteredNumber);
				parent.setDisplayValue("" + currentNumber);
			}
		}

		else {

			if (!clickedButton.getText().equals("=")) {
				if ((clickedButton.getText().equals(".")) && dot) {
				} else {
					// Get the button's label
					String clickedButtonLabel = clickedButton.getText();
					parent.setDisplayValue(dispFieldText + clickedButtonLabel);
				}

			}
		}
	}
}
