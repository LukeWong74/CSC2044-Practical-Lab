import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> array = new LinkedList<Integer>();

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
