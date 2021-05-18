public class Producer {

	final int CREATE_AUTO = 5000;

	private static AutoShowroom autoShowroom;
	public Producer(AutoShowroom autoShowroom) {
		this.autoShowroom = autoShowroom;
	}
	public Producer() { }

	public synchronized boolean sellAuto() {
		try {
			while (autoShowroom.getAuto().size() == 0) {
				System.out.println("Машин нет");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return autoShowroom.getAuto().remove(0);
	}

	public synchronized void receiveAuto() {
		try {
			Thread.sleep(CREATE_AUTO);
			autoShowroom.getAuto().add(new Auto());
			System.out.println(Thread.currentThread().getName()  + " выпустил 1 авто");
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
