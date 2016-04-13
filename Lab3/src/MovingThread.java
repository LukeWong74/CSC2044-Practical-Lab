public class MovingThread implements Runnable {
	Robot robot;

	public MovingThread(Robot robot) {
		this.robot = robot;
	}

	public void run() {
		boolean check;
		while (true) {
			try {
				check = robot.move();

				if (check == true)
					Thread.sleep(600);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
