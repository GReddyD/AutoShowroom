import java.util.function.Consumer;

public class Main {

	private final static int TIME_VISIT = 7000;
	private static int CNT_STREAM = 3;

	public static void main(String[] args){

		AutoShowroom autoShowroom = new AutoShowroom();
		Producer producer = new Producer(autoShowroom);
		Consumer consumer = new Consumer(autoShowroom)

		new Thread(null, consumer, "Покупатель 1").start();
		new Thread(null, consumer, "Покупатель 2").start();
		new Thread(null, consumer, "Покупатель 3").start();
		new Thread(null, producer, "Производитель Toyota").start();

		while (true) {
			if (autoShowroom.getSales() < autoShowroom.PLAN_FOR_SALES) {
				try {
					Thread.sleep(TIME_VISIT);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				new Thread(null, consumer, "Покупатель " + ++CNT_STREAM).start();
			} else {
				break;
			}
		}

	}
}