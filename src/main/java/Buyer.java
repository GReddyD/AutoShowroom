public class Buyer {
	public void buyAuto(){
		final int TIME_BUY = 3000;
		AutoShowroom autoShowroom = new AutoShowroom(this);

		// Критическая  секция
		synchronized  (autoShowroom)  { System.out.println(Thread.currentThread().getName()  +  " зашел в автосалон");
			// Процесс  покупки.  Эмулируем,  приостанавливая  поток
			try  {
				Thread.sleep(TIME_BUY);
				autoShowroom.sellAuto();
			}  catch  (InterruptedException  e)  {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()  +  " уехал на новеньком авто");
		}
	}
}
