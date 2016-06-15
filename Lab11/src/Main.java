import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		Fork fork1 = new Fork();
		Fork fork2 = new Fork();
		Fork fork3 = new Fork();
		Fork fork4 = new Fork();
		Fork fork5 = new Fork();
		
		Philosopher p1 = new Philosopher(fork5, fork1, "Philosopher 1");
		Philosopher p2 = new Philosopher(fork1, fork2, "Philosopher 2");
		Philosopher p3 = new Philosopher(fork2, fork3, "Philosopher 3");
		Philosopher p4 = new Philosopher(fork3, fork4, "Philosopher 4");
		Philosopher p5 = new Philosopher(fork4, fork5, "Philosopher 5");
		
		exec.submit(p1);
		exec.submit(p2);
		exec.submit(p3);
		exec.submit(p4);
		exec.submit(p5);
		
		try {
			exec.awaitTermination(10000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
