import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class GenerateNumbers implements Runnable {
	ArrayBlockingQueue<Integer> array;
	Random rdm = new Random();

	public GenerateNumbers(ArrayBlockingQueue<Integer> array) {
		this.array = array;
	}

	public void run() {
		while (true) {
			for (int x = 0; x < 5; x++) {
				int rdmNum = 1 + rdm.nextInt(100);

				try {
					array.put(rdmNum);
					System.out.println("Added " + rdmNum);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				System.out.println("Wait for 5sec");
				Thread.sleep(5000);
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
