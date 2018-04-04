import java.util.Scanner;

public class Fibonnaci {

	static int fibonnaci(int n) {

		if (n <= 1) {
			return n;

		}

		return fibonnaci(n - 1) + fibonnaci(n - 2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = scanner.nextInt();

		int result = fibonnaci(n);
		System.out.println(result);
	}

}
