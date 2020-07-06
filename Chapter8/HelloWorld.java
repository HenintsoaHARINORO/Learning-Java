import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloWorld extends JFrame {
	public static void main(String[] args) {
		JFrame myWindow = new HelloWorld();
		JButton myButton= new JButton("Click me");
		myWindow.add(myButton);
		myWindow.setSize(200,300);
		myWindow.setTitle("Hello World");
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
