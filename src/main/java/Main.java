public class Main {
	public static void main(String[] args) throws InterruptedException {
		final Producer producer = new Producer();
		final Buyer buyer = new Buyer();

		// Идем за покупкой авто
		Runnable shopping = buyer::buyAuto;
		Runnable createAuto = producer::receiveAuto;
		new Thread(null, shopping, "Покупатель 1").start();
		new Thread(null, createAuto, "Производитель Toyota").start();
		new Thread(null, shopping, "Покупатель 2").start();
		new Thread(null, createAuto, "Производитель Mercedes").start();
		new Thread(null, shopping, "Покупатель 3").start();
		new Thread(null, createAuto, "Производитель Mazda").start();
	}
}
