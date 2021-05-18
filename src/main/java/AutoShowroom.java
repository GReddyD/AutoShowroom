import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutoShowroom {
	final int SIZE_LIST_AUTO = 10;
	final int TIME_BUY = 3000;

	Producer producer = new Producer(this);
	List<Auto> autos = new ArrayList<>(SIZE_LIST_AUTO);

	public AutoShowroom() {

	}

	public void sellAuto(){
		synchronized (producer) {
			System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
			try {
				Thread.sleep(TIME_BUY);
				producer.sellAuto();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
		}
	}

	public void acceptAuto() {
		synchronized (producer) {
			try {
				producer.receiveAuto();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	Collection<Auto> getAuto() {
		return autos;
	}
}