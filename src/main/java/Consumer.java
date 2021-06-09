public class Consumer implements Runnable {

	AutoShowroom autoShowroom;

	Consumer(AutoShowroom autoShowroom) {
		this.autoShowroom = autoShowroom;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
		if (autoShowroom.getProduct() < 1) {
			System.out.println("Автосалон: автомобиля нет в наличии");
		}
		autoShowroom.saleAuto();
		System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
		Thread.currentThread().interrupt();
	}
}
