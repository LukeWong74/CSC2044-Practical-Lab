import java.util.Queue;

public class TakingNumbers implements Runnable {
	Queue<Integer> array;
	GenerateNumbers generateNum;
	boolean ready = true;

	public TakingNumbers(Queue<Integer> array) {
		this.array = array;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			for (int x = 0; x < 5; x++) {
				synchronized (array) {

					while (array.isEmpty()) {
						try {
							System.out.println("Waiting for T2");
							array.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println("Taking " + array);
					array.remove();
					array.notifyAll();
				}
			}

			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
