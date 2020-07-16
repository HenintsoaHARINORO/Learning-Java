
public class TestThreads2Lambda {
public static void main(String [] args) {
	Thread mn= new Thread(()->System.out.println("The stock market is improving"),"Market News");
	mn.start();
	Thread p= new Thread(()->System.out.println("You have 500 shares of IBM"),"Portfolio data");
	p.start();
	System.out.println("TestThreads2 s finished");
}
}
