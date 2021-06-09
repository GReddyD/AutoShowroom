public class Producer implements Runnable{
	AutoShowroom autoShowroom;

	Producer(AutoShowroom autoShowroom) {
		this.autoShowroom = autoShowroom;
	}

	@Override
	public void run() {
		while (true) {
			if (autoShowroom.getSales() == autoShowroom.PLAN_FOR_SALES) {
				break;
			}
			autoShowroom.createAuto();
		}
	}
}
