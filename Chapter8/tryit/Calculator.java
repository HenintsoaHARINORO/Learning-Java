
package tryit;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Calculator extends JFrame {

	private JPanel windowContent;
	private JTextField displayField;
	private JButton[] buttons;
	private String[] buttonNames;

	private GridBagLayout gridBagLayout;
	private GridBagConstraints constraints;

	public String getDisplayFieldText() {
		return displayField.getText();
	}

	public void setDisplayFieldText(String text) {
		this.displayField.setText(text);
	}

	Calculator() {

		super("Calculator");

		CalculatorEngine calculatorEngine = new CalculatorEngine(this);

		windowContent = new JPanel();

		gridBagLayout = new GridBagLayout();
		windowContent.setLayout(gridBagLayout);

		constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.anchor = GridBagConstraints.CENTER;

		displayField = new JTextField();
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		addComponent(windowContent, displayField, 0, 0, 7, 1);

		String[] buttonNames = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "=", "+", "-", "*", "/" };

		buttons = new JButton[buttonNames.length];

		for (int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(calculatorEngine);
		}

		addComponent(windowContent, buttons[1], 1, 0, 2, 1);
		addComponent(windowContent, buttons[2], 1, 2, 2, 1);
		addComponent(windowContent, buttons[3], 1, 4, 2, 1);
		addComponent(windowContent, buttons[12], 1, 6, 1, 1);

		addComponent(windowContent, buttons[4], 2, 0, 2, 1);
		addComponent(windowContent, buttons[5], 2, 2, 2, 1);
		addComponent(windowContent, buttons[6], 2, 4, 2, 1);
		addComponent(windowContent, buttons[13], 2, 6, 1, 1);

		addComponent(windowContent, buttons[7], 3, 0, 2, 1);
		addComponent(windowContent, buttons[8], 3, 2, 2, 1);
		addComponent(windowContent, buttons[9], 3, 4, 2, 1);
		addComponent(windowContent, buttons[14], 3, 6, 1, 1);

		addComponent(windowContent, buttons[0], 4, 0, 2, 1);
		addComponent(windowContent, buttons[10], 4, 2, 2, 1);
		addComponent(windowContent, buttons[11], 4, 4, 2, 1);
		addComponent(windowContent, buttons[15], 4, 6, 1, 1);

		setContentPane(windowContent);
		setVisible(true);
		pack();
	}

	private void addComponent(Container container, Component component, int row, int column, int width, int height) {
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		gridBagLayout.setConstraints(component, constraints);
		container.add(component);
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	}

}