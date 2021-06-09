public class AutoShowroom {

	private final static int SELL_TIME = 2000;
	public final static int PLAN_FOR_SALES = 10;
	private final static int CREATE_AUTO = 2000;
	private int cntProduceAuto = 0;
	private int cntSalesAuto = 0;

	public int getSales() {
		return cntSalesAuto;
	}
	public int getProduct() {
		return cntProduceAuto;
	}

	public synchronized void saleAuto() {
		try {
			while (cntProduceAuto == 0) {
				wait();
			}
			Thread.sleep(SELL_TIME);
			cntProduceAuto--;
			cntSalesAuto++;
			notifyAll();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	public synchronized void createAuto() {
		try {
			while (cntProduceAuto > 0) {
				wait();
			}
			Thread.sleep(CREATE_AUTO);
			cntProduceAuto++;
			System.out.println(Thread.currentThread().getName() + " выпустил авто");
			notify();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}