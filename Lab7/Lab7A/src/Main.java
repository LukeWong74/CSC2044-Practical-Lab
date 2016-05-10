import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
	static double minimum = Double.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<Double>> futureList = new ArrayList<Future<Double>>();
		double[][] array_200 = new double[200][100];

		Random rdm = new Random();
		long start_time;
		long end_time;

		// initialize for both 200 and 20 arrays
		for (int x = 0; x < 200; x++) {
			for (int y = 0; y < 100; y++) {
				double initialMin = -5.12;
				double initialMax = 5.12;

				double value = initialMin + rdm.nextDouble()
						* (initialMax - initialMin);

				array_200[x][y] = value;
			}
		}

		// 200 threads
		// start time
		start_time = System.currentTimeMillis();

		for (int x = 0; x < 200; x++) {
			Task1 task1 = new Task1(array_200[x], x);

			Future<Double> future = exec.submit(task1);
			futureList.add(future);
		}

		for (Future<Double> futureget : futureList) {
			double min = 0;

			try {
				min = futureget.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (min < minimum) {
				minimum = min;
			}
		}

		exec.shutdown();

		try {
			exec.awaitTermination(10000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// end time
		end_time = System.currentTimeMillis();

		System.out
				.printf("\nTotal time for 200 threads with Hill Climber: %d\nThe minimum value: %.2f\n\n",
						end_time - start_time, minimum);
	}
}
