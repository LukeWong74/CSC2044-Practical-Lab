import java.util.Random;

public class Task1 implements Runnable {
	double[] array;
	double[] tempArray;
	Random rdm = new Random();
	double minimumValue = Double.MAX_VALUE;
	int length;

	public Task1(double[] array, int length) {
		this.array = array;
		this.length = length;
		this.tempArray = array.clone();
	}

	@Override
	public void run() {
		double result = 0;
		double tempValue = 0;
		double min = Double.MAX_VALUE;

		// TODO Auto-generated method stub
		for (int x = 0; x < 350; x++) {
			
			for (int y = 0; y < 100; y++) {
				result += (array[y] * array[y]) * y;
			}

			for (int b = 0; b < 100; b++) {
				double value = -0.5 + rdm.nextDouble() * 0.5;
				tempValue = array[b];

				if (array[b] + value > -5.12 && array[b] + value < 5.12)
					array[b] += value;
				else
					array[b] = tempValue;
			}

			if (result < min) {
				min = result;

				if (min < minimumValue)
					minimumValue = min;

				for (int z = 0; z < 100; z++)
					tempArray[z] = array[z];
			} else {
				for (int z = 0; z < 100; z++)
					array[z] = tempArray[z];
			}
		}
		Main.minArray[length] = minimumValue;
	}
}
