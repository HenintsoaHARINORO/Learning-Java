import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversionGuiFile  extends JFrame{
	JLabel lbDecimalNum;
	JTextField txtDecimalNum = new JTextField(15);
	
	JLabel operator = new JLabel("Operators: ");
	
	Vector<String> operators = new Vector<>(50);
	JComboBox operation = new JComboBox(operators);
	JLabel lblResult = new JLabel("Result: ");
	JTextField txtResult = new JTextField(10);
	JButton bGo = new JButton("Go");
	JButton bReset = new JButton("Reset");
	

	ConversionGuiFile() {
		lbDecimalNum = new JLabel("Decimal Number: ");
		GridLayout gr = new GridLayout(5, 2, 1, 1);
		setLayout(gr);
		add(lbDecimalNum);
		add(txtDecimalNum);
		add(operator);
		add(operation);
		add(lblResult);
		add(txtResult);
		add(bGo);
		add(bReset);

		populateStates();
		operation.setSelectedIndex(0);
		txtResult.setEditable(false);

		bGo.addActionListener(evt -> {
			try {
				int DecimalNum = Integer.parseInt(txtDecimalNum.getText());
				
				String oper = (String) operation.getSelectedItem();
				ApplConvertir t = new ApplConvertir(DecimalNum);
				String sTax = t.ToHexa(DecimalNum);
				txtResult.setText(sTax);
			} catch (NumberFormatException e) {

				txtResult.setText("Non-Numeric Data");
			} catch (Exception e) {
				txtResult.setText(e.getMessage());
			}
		});

		bReset.addActionListener(evt -> {
			txtDecimalNum.setText("");
		
			operation.setSelectedIndex(0);
			txtResult.setText("");
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void populateStates() {
		operators.add("Select Operation");
		try (FileInputStream myFile = new FileInputStream("operation.txt");
			    InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF8");
				BufferedReader reader = new BufferedReader(inputStreamReader);) {
			String stateName;
			while ((stateName = reader.readLine()) != null) {
				operators.add(stateName);
			}
		} catch (IOException ioe) {
			txtResult.setText("Can't read states.txt: " + ioe.getMessage());
		}
	}
	public static void main(String args[]) {
		ConversionGuiFile taxFrame = new ConversionGuiFile();
		taxFrame.setSize(400, 150);
		taxFrame.setVisible(true);
	}

}
