import java.util.Random;

public class Robot {
	Random rdm = new Random();
	private final int[][] matrix_8x8;
	private int row, col;
	private int new_row = 0, new_col = 0;

	public Robot(int[][] matrix_8x8) {
		this.matrix_8x8 = matrix_8x8;
	}

	public void setCoordinate() {
		// set all to 0
		for (int x = 0; x < matrix_8x8.length; x++) {
			for (int y = 0; y < matrix_8x8.length; y++) {
				matrix_8x8[x][y] = 0;
			}
		}

		// initial coordinate
		row = 0;
		col = 0;
		matrix_8x8[row][col] = 1;
	}

	public boolean move() {
		int move = 1 + rdm.nextInt(8);
		boolean flag = false;

		for (int x = 0; x < matrix_8x8.length; x++) {
			for (int y = 0; y < matrix_8x8.length; y++) {
				// up
				if (move == 1) {
					if (row > 0) {
						new_row = row - 1;
						new_col = col;
						flag = true;
					}
				}
				// left
				else if (move == 2) {
					if (col > 0) {
						new_row = row;
						new_col = col - 1;
						flag = true;
					}
				}
				// right
				else if (move == 3) {
					if (col < 7) {
						new_row = row;
						new_col = col + 1;
						flag = true;
					}
				}
				// down
				else if (move == 4) {
					if (row < 7) {
						new_row = row + 1;
						new_col = col;
						flag = true;
					}
				}
				// up left
				else if (move == 5) {
					if (row > 0 && col > 0) {
						new_row = row - 1;
						new_col = col - 1;
						flag = true;
					}
				}
				// up right
				else if (move == 6) {
					if (row > 0 && col < 7) {
						new_row = row - 1;
						new_col = col + 1;
						flag = true;
					}
				}
				// down left
				else if (move == 7) {
					if (row < 7 && col > 0) {
						new_row = row + 1;
						new_col = col - 1;
						flag = true;
					}
				}
				// down right
				else if (move == 8) {
					if (row < 7 && col < 7) {
						new_row = row + 1;
						new_col = col + 1;
						flag = true;
					}
				}

			}
		}

		// set the robot position after validation for movement
		synchronized (matrix_8x8) {
			matrix_8x8[row][col] = 0;
			matrix_8x8[new_row][new_col] = 1;
		}

		// set new row and col as previous for next turn
		row = new_row;
		col = new_col;

		return flag;
	}

	public void displayMap() {
		synchronized (matrix_8x8) {
			for (int x = 0; x < matrix_8x8.length; x++) {
				for (int y = 0; y < matrix_8x8.length; y++) {
					System.out.print(matrix_8x8[x][y] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
