public class Main {

	private final static int TIME_VISIT = 7000;
	private static int CNT_STREAM = 3;

	public static void main(String[] args){

		AutoShowroom autoShowroom = new AutoShowroom();
		Producer producer = new Producer(autoShowroom);
		Buyer buyer = new Buyer(autoShowroom);

		new Thread(null, buyer, "Покупатель 1").start();
		new Thread(null, buyer, "Покупатель 2").start();
		new Thread(null, buyer, "Покупатель 3").start();
		new Thread(null, producer, "Производитель Mazda").start();

		while (true) {
			if (autoShowroom.getSales() < autoShowroom.PLAN_FOR_SALES) {
				try {
					Thread.sleep(TIME_VISIT);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				new Thread(null, buyer, "Покупатель " + ++CNT_STREAM).start();
			} else {
				break;
			}
		}

	}
}