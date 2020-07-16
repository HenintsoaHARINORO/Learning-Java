
public class TestThreads3LambdaJoin {

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
		Thread marketNews = new Thread(mn, "Market News");
		Thread portfolio = new Thread(port, "Portfolio data");
		marketNews.start();
		portfolio.start();

		try {
			marketNews.join();
			portfolio.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The main method of TestThreads3LambdaJoin is finished");
	}

}
