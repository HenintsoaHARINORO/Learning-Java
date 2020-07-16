
public class TestThread3Lambda {
	public static void main(String[] args) {
		Runnable mn = () -> {
			try {
				for (int i = 0; i < 10; i += 1) {
					Thread.sleep(1000);
					System.out.println("The market is improving " + i);
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};
		Thread marketNews = new Thread(mn, "Market News");
		marketNews.start();
		
		Runnable port = () -> {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(700);
					
					System.out.println("You have " + (500 + i) + " shares of IBM");
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};
		Thread portfolio = new Thread(port, "Portfolio data");
		portfolio.start();
		System.out.println("The main method of TestThreads3Lambda is finished");
	}
}
