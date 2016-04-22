import java.util.Random;
import java.util.Queue;

public class GenerateNumbers implements Runnable {
	Queue<Integer> array;
	Random rdm = new Random();

	public GenerateNumbers(Queue<Integer> array) {
		this.array = array;
	}

	public void run() {
		while (true) {
			for (int x = 0; x < 5; x++) {
				int rdmNum = 1 + rdm.nextInt(100);

				synchronized (array) {
					while (array.size() == 5) {
						try {
							System.out.println("Waiting for T1");
							array.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					array.add(rdmNum);
					System.out.println("Added " + rdmNum);
					array.notifyAll();
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
