
public class KillTheThread {
	public static void main(String[] args) {
		PortfolioVolatile p = new PortfolioVolatile("Portfolio data");
		p.start();
		
		
		int i = 0;
		do {
			System.out.println(" i= " + i++);
		} while (i < 100);

		p.stopMe();
	}

}
