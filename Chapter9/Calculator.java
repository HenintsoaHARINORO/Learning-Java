import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Calculator {
	JPanel windowContent;
	private JTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	JButton buttonEqual;
	JPanel p1, p2;
	JButton buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonPow;

	public void setDisplayValue(String val) {
		displayField.setText(val);
	}

	public String getDisplayValue() {
		return displayField.getText();
	}

	Calculator() {
		windowContent = new JPanel();
		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);

		displayField = new JTextField(30);
		windowContent.add("North", displayField);

		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");

		p1 = new JPanel();
		GridLayout gl = new GridLayout(4, 3);
		p1.setLayout(gl);

		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button0);
		p1.add(buttonPoint);
		p1.add(buttonEqual);

		CalculatorEngine calcEngine = new CalculatorEngine(this);
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		buttonPoint.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);

		windowContent.add("Center", p1);

		p2 = new JPanel();
		GridLayout eastL = new GridLayout(4, 1);
		p2.setLayout(gl);

		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonMultiply = new JButton("*");
		buttonDivide = new JButton("/");
		buttonPow = new JButton("^");

		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);
		p2.add(buttonPow);

		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);
		buttonDivide.addActionListener(calcEngine);
		buttonPow.addActionListener(calcEngine);

		windowContent.add("East", p2);

		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);

		frame.pack();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}
