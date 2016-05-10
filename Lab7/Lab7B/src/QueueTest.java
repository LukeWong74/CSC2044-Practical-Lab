import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> array = new ArrayBlockingQueue<Integer>(4);

		GenerateNumbers task1 = new GenerateNumbers(array);
		TakingNumbers task2 = new TakingNumbers(array);

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
