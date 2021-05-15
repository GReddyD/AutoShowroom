import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutoShowroom {
	final int SIZE_LIST_AUTO = 10;
	// Создаем объект производителя
	private static Buyer buyer;
	Producer producer = new Producer(this);
	List<Auto> autos = new ArrayList<>(SIZE_LIST_AUTO);

	public AutoShowroom(Buyer buyer) {
		this.buyer = buyer;
	}

	public void sellAuto() {
		synchronized (producer) {
			try {
				producer.sellAuto();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	Collection<Auto> getAuto() {
		return autos;
	}
}