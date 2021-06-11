public class AutoShowroom {

	public final static int PLAN_FOR_SALES = 10;
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
			cntProduceAuto++;
			System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
			notify();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}