
package tryit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	private static final String ERROR_MESSAGE = "Error!";
	// Events
	private static final int DIGIT_BUTTON_PRESSED = 1;
	private static final int OPERATION_BUTTON_PRESSED = 2;
	private static final int EQUAL_BUTTON_PRESSED = 3;

	private int currentEvent;
	private String currentButtonValue;

	private Calculator calculator;
	private Operations operation;
	private Double firstArg;
	private Double secondArg;
	private Double operationResult;

	public CalculatorEngine(Calculator calculator) {
		this.calculator = calculator;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		Object eventSource = actionEvent.getSource();

		if (eventSource instanceof JButton) {
			processButtonClick((JButton) eventSource);
		}
	}

	private Boolean x1() {
		if (firstArg == null && secondArg == null && operationResult == null)
			return true;
		else
			return false;
	}

	private Boolean x2() {
		if (firstArg != null && secondArg == null && operationResult == null)
			return true;
		else
			return false;
	}

	private Boolean x3() {
		if (firstArg == null && secondArg != null && operationResult != null)
			return true;
		else
			return false;
	}

	private Double doCalculation() {

		Double ret = null;

		switch (operation) {
		case ADDITION:
			ret = firstArg + secondArg;
			break;
		case SUBTRACTION:
			ret = firstArg - secondArg;
			break;
		case DIVISION:
			if (secondArg != 0)
				ret = firstArg / secondArg;
			break;
		case MULTIPLYING:
			ret = firstArg * secondArg;
			break;
		case ILLEGAL_OPERATION:
		default:
			break;
		}

		return ret;

	}

	private Operations getOperationFromString(String string) {
		if (string == "+") {
			return Operations.ADDITION;
		} else if (string == "-") {
			return Operations.SUBTRACTION;
		} else if (string == "*") {
			return Operations.MULTIPLYING;
		} else if (string == "/") {
			return Operations.DIVISION;
		} else {
			return Operations.ILLEGAL_OPERATION;
		}
	}

	private Double parceStringToFloat(String myString) {
		Double ret = null;

		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";

		final String Exp = "[eE][+-]?" + Digits;
		final String fpRegex = ("[\\x00-\\x20]*" + "[+-]?(" + "NaN|" + "Infinity|" +

				"(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +

				"(\\.(" + Digits + ")(" + Exp + ")?)|" +

				"((" +

				"(0[xX]" + HexDigits + "(\\.)?)|" +

				"(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

				")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");

		if (Pattern.matches(fpRegex, myString))
			ret = Double.valueOf(myString);

		return ret;
	}

	private void processButtonClick(JButton button) {

		currentButtonValue = button.getText();

		if (currentButtonValue == "=") {
			currentEvent = EQUAL_BUTTON_PRESSED;
		} else if (currentButtonValue == "-" || currentButtonValue == "+" || currentButtonValue == "/"
				|| currentButtonValue == "*") {
			currentEvent = OPERATION_BUTTON_PRESSED;
		} else {
			currentEvent = DIGIT_BUTTON_PRESSED;
		}

		if (calculator.getDisplayFieldText().equals(ERROR_MESSAGE)) {
			calculator.setDisplayFieldText("");
		}

		switch (currentEvent) {

		case 1:

			if (x1() || x2()) {
				calculator.setDisplayFieldText(calculator.getDisplayFieldText() + currentButtonValue);
			}

			if (x3()) {
				calculator.setDisplayFieldText(currentButtonValue);
				firstArg = null;
				secondArg = null;
				operationResult = null;
			}
			break;

		case 2:
			operation = getOperationFromString(currentButtonValue);

			if (x1()) {
				firstArg = parceStringToFloat(calculator.getDisplayFieldText());
				calculator.setDisplayFieldText("");
				break;
			}

			if (x2() || x3()) {
				calculator.setDisplayFieldText("");
				firstArg = null;
				secondArg = null;
				operationResult = null;
			}

			break;

		case 3:

			if (x1()) {
				calculator.setDisplayFieldText("");
				break;
			}

			if (x2()) {
				secondArg = parceStringToFloat(calculator.getDisplayFieldText());
				if (secondArg != null) {
					operationResult = doCalculation();
					firstArg = null;
					if (operationResult == null) {
						calculator.setDisplayFieldText(ERROR_MESSAGE);
						secondArg = null;

					} else {
						calculator.setDisplayFieldText(Double.toString(operationResult));

					}
				}
				firstArg = null;
				break;
			}

			if (x3()) {
				if (operationResult.equals(parceStringToFloat(calculator.getDisplayFieldText()))) {
					firstArg = operationResult;
					if (secondArg != null) {
						operationResult = doCalculation();
						firstArg = null;
						if (operationResult == null) {
							calculator.setDisplayFieldText(ERROR_MESSAGE);
							secondArg = null;

						} else {
							calculator.setDisplayFieldText(Double.toString(operationResult));

						}
					}
				} else {
					firstArg = null;
					secondArg = null;
					operationResult = null;

				}
			}
			break;

		}

	}

}