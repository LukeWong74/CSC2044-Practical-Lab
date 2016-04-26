import java.util.Random;

public class Task1 implements Runnable {
	double[] array;
	Random rdm = new Random();
	double minimumValue = Double.MAX_VALUE;

	public Task1(double[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		double result = 0;

		// TODO Auto-generated method stub
		for (int x = 0; x < 350; x++) {
			for (int y = 0; y < 100; y++) {
				result += (array[y] * array[y]) * y;

				double value = -0.5 + rdm.nextDouble() * 0.5;

				if (array[y] + value > -5.12 && array[y] + value < 5.12)
					array[y] += value;
			}

			if (result < minimumValue)
				minimumValue = result;
		}
		setMinimumValue(minimumValue);
	}

	public void setMinimumValue(double minimum) {
		minimumValue = minimum;
	}

	public double getMinimumValue() {
		return minimumValue;
	}
}
