import java.util.concurrent.ArrayBlockingQueue;

public class TakingNumbers implements Runnable {
	ArrayBlockingQueue<Integer> array;

	public TakingNumbers(ArrayBlockingQueue<Integer> array) {
		this.array = array;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println("Taking " + array.take());

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
