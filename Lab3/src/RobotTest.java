public class RobotTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix_8x8 = new int[8][8];
		Robot r1 = new Robot(matrix_8x8);
		r1.setCoordinate();

		MovingThread move1 = new MovingThread(r1);
		DisplayThread display1 = new DisplayThread(r1);

		Thread t1 = new Thread(move1);
		Thread t2 = new Thread(display1);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
