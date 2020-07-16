
public class TestLambdaWaitNotify {

	private static Runnable getMktNewsRunnable(Object whoToNotify) {

		return () -> {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
					System.out.println("The market is improving " + i);
				}

				synchronized (whoToNotify) {
					whoToNotify.notify();
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};
	}

	public static void main(String args[]) {

		TestLambdaWaitNotify thisInstance = new TestLambdaWaitNotify();
		;

		Runnable mktNewsRunnable = getMktNewsRunnable(thisInstance);
		Thread marketNews = new Thread(mktNewsRunnable, "");
		marketNews.start();

		synchronized (thisInstance) {
			try {
				thisInstance.wait(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("The main method of TestLambdaWaitNotify is finished");
	}
}
