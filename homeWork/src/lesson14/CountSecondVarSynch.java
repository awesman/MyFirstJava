package lesson14;

/**
 * Усовершенствовать предыдущее приложение, 
 * обеспечив синхронизацию, чтобы потоки выводили строки по очереди.
 * @author Pavel
 * @version 2
 */
public class CountSecondVarSynch {

	public static void main(String[] args) {
		Object o = new Object();

		NewThread T1 = new NewThread(o);
		NewThread T2 = new NewThread(o);

		T1.start();
		T2.start();
	}
}

class NewThread extends Thread {
	Thread th;
	public Object o = new Object();
	public NewThread(Object o) {
		this.o = o;
		th = new Thread();
	}

	@Override
	public void run() {
		synchronized (o) {
			// Cделал немного другой вывод
			for (int i = 0; i < 10; i++) {
				System.out.println(th.getName() + ":" + " "
						+ (i * 10 + 1) + " " + (i * 10 + 2) + " "
						+ (i * 10 + 3) + " " + (i * 10 + 4) + " "
						+ (i * 10 + 5) + " " + (i * 10 + 6) + " "
						+ (i * 10 + 7) + " " + (i * 10 + 8) + " "
						+ (i * 10 + 9) + " " + (i * 10 + 10));
				o.notify();
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}