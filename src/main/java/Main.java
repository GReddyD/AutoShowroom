public class Main {
	public static void main(String[] args){
		final AutoShowroom autoShowroom = new AutoShowroom();

		// Идем за покупкой авто
		Runnable shopping = autoShowroom::sellAuto;
		Runnable createAuto = autoShowroom::acceptAuto;
		new Thread(null, shopping, "Покупатель 1").start();
		new Thread(null, shopping, "Покупатель 2").start();
		new Thread(null, shopping, "Покупатель 3").start();
		new Thread(null, createAuto, "Производитель Toyota").start();
		new Thread(null, createAuto, "Производитель Mercedes").start();
		new Thread(null, createAuto, "Производитель Mazda").start();
	}
}