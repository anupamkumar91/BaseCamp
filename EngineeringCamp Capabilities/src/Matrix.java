import java.util.Scanner;

public class Matrix {

	static void compare(int[][] arr, int x) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns you want:");
		int rows = scanner.nextInt();
		int colm = scanner.nextInt();
		int[][] matrix = new int[rows][colm];
		System.out.println("Enter the element in the matrix:");
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < colm; j++) {

				matrix[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < colm; j++) {

				compare(matrix, matrix[i][j]);
			}
		}

		System.out.println("Matrix element are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colm; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

	}

}
