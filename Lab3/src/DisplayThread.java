public class DisplayThread implements Runnable {
	Robot robot;

	public DisplayThread(Robot robot) {
		this.robot = robot;
	}

	public void run() {
		while (true) {
			try {
				robot.displayMap();
				Thread.sleep(300);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
